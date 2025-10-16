"""
Create namespaced packages for short-form access

See bin/enable-namespacing.py for background information on why this module exists
"""

from pathlib import Path


def extend_namespace(file_path, module_search_path, pkg_name, relative_py_roots):
    """When looking up the top-level of _pkg_name_, include all the
    _relative_py_roots_ in the search path by appending them to _path_

    file_path           - __file__
    module_search_path  - __path__
    pkg_name            - __name__
    relative_py_roots   - the other folders to add to the search path
    """

    here = Path(file_path).resolve().parent
    pkg = pkg_name.split(".")[0]
    for rel in relative_py_roots:
        pyroot = (here / rel).resolve()
        cand = pyroot / pkg
        if cand.is_dir():
            p = str(cand)
            if p not in module_search_path:
                module_search_path.append(p)
