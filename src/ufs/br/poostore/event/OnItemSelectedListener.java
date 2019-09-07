package ufs.br.poostore.event;

import ufs.br.poostore.views.ListPanel;

public interface OnItemSelectedListener<T> {
    void loadInfo(ListPanel listPanel, T obj);
}
