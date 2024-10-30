package fpml.confirmation;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.confirmation.Clearing;
import fpml.confirmation.ClearingResultsModel;
import fpml.confirmation.ClearingResultsModel.ClearingResultsModelBuilder;
import fpml.confirmation.ClearingResultsModel.ClearingResultsModelBuilderImpl;
import fpml.confirmation.ClearingResultsModel.ClearingResultsModelImpl;
import fpml.confirmation.ClearingResultsModelSequence;
import fpml.confirmation.DeClear;
import fpml.confirmation.TradingEventsModel;
import fpml.confirmation.meta.ClearingResultsModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Events/Results that are applicable to clearing processes.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="ClearingResultsModel", builder=ClearingResultsModel.ClearingResultsModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface ClearingResultsModel extends RosettaModelObject {

	ClearingResultsModelMeta metaData = new ClearingResultsModelMeta();

	/*********************** Getter Methods  ***********************/
	TradingEventsModel getTradingEventsModel();
	ClearingResultsModelSequence getClearingResultsModelSequence();
	/**
	 * A structure describing a declear event. The deClear event allows a firm to request that a trade be removed from clearing, or a clearing service to request consent for this, or to report that it has been done.
	 */
	DeClear getDeClear();
	Clearing getClearing();

	/*********************** Build Methods  ***********************/
	ClearingResultsModel build();
	
	ClearingResultsModel.ClearingResultsModelBuilder toBuilder();
	
	static ClearingResultsModel.ClearingResultsModelBuilder builder() {
		return new ClearingResultsModel.ClearingResultsModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ClearingResultsModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ClearingResultsModel> getType() {
		return ClearingResultsModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("tradingEventsModel"), processor, TradingEventsModel.class, getTradingEventsModel());
		processRosetta(path.newSubPath("clearingResultsModelSequence"), processor, ClearingResultsModelSequence.class, getClearingResultsModelSequence());
		processRosetta(path.newSubPath("deClear"), processor, DeClear.class, getDeClear());
		processRosetta(path.newSubPath("clearing"), processor, Clearing.class, getClearing());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ClearingResultsModelBuilder extends ClearingResultsModel, RosettaModelObjectBuilder {
		TradingEventsModel.TradingEventsModelBuilder getOrCreateTradingEventsModel();
		TradingEventsModel.TradingEventsModelBuilder getTradingEventsModel();
		ClearingResultsModelSequence.ClearingResultsModelSequenceBuilder getOrCreateClearingResultsModelSequence();
		ClearingResultsModelSequence.ClearingResultsModelSequenceBuilder getClearingResultsModelSequence();
		DeClear.DeClearBuilder getOrCreateDeClear();
		DeClear.DeClearBuilder getDeClear();
		Clearing.ClearingBuilder getOrCreateClearing();
		Clearing.ClearingBuilder getClearing();
		ClearingResultsModel.ClearingResultsModelBuilder setTradingEventsModel(TradingEventsModel tradingEventsModel);
		ClearingResultsModel.ClearingResultsModelBuilder setClearingResultsModelSequence(ClearingResultsModelSequence clearingResultsModelSequence);
		ClearingResultsModel.ClearingResultsModelBuilder setDeClear(DeClear deClear);
		ClearingResultsModel.ClearingResultsModelBuilder setClearing(Clearing clearing);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("tradingEventsModel"), processor, TradingEventsModel.TradingEventsModelBuilder.class, getTradingEventsModel());
			processRosetta(path.newSubPath("clearingResultsModelSequence"), processor, ClearingResultsModelSequence.ClearingResultsModelSequenceBuilder.class, getClearingResultsModelSequence());
			processRosetta(path.newSubPath("deClear"), processor, DeClear.DeClearBuilder.class, getDeClear());
			processRosetta(path.newSubPath("clearing"), processor, Clearing.ClearingBuilder.class, getClearing());
		}
		

		ClearingResultsModel.ClearingResultsModelBuilder prune();
	}

	/*********************** Immutable Implementation of ClearingResultsModel  ***********************/
	class ClearingResultsModelImpl implements ClearingResultsModel {
		private final TradingEventsModel tradingEventsModel;
		private final ClearingResultsModelSequence clearingResultsModelSequence;
		private final DeClear deClear;
		private final Clearing clearing;
		
		protected ClearingResultsModelImpl(ClearingResultsModel.ClearingResultsModelBuilder builder) {
			this.tradingEventsModel = ofNullable(builder.getTradingEventsModel()).map(f->f.build()).orElse(null);
			this.clearingResultsModelSequence = ofNullable(builder.getClearingResultsModelSequence()).map(f->f.build()).orElse(null);
			this.deClear = ofNullable(builder.getDeClear()).map(f->f.build()).orElse(null);
			this.clearing = ofNullable(builder.getClearing()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("tradingEventsModel")
		public TradingEventsModel getTradingEventsModel() {
			return tradingEventsModel;
		}
		
		@Override
		@RosettaAttribute("clearingResultsModelSequence")
		public ClearingResultsModelSequence getClearingResultsModelSequence() {
			return clearingResultsModelSequence;
		}
		
		@Override
		@RosettaAttribute("deClear")
		public DeClear getDeClear() {
			return deClear;
		}
		
		@Override
		@RosettaAttribute("clearing")
		public Clearing getClearing() {
			return clearing;
		}
		
		@Override
		public ClearingResultsModel build() {
			return this;
		}
		
		@Override
		public ClearingResultsModel.ClearingResultsModelBuilder toBuilder() {
			ClearingResultsModel.ClearingResultsModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ClearingResultsModel.ClearingResultsModelBuilder builder) {
			ofNullable(getTradingEventsModel()).ifPresent(builder::setTradingEventsModel);
			ofNullable(getClearingResultsModelSequence()).ifPresent(builder::setClearingResultsModelSequence);
			ofNullable(getDeClear()).ifPresent(builder::setDeClear);
			ofNullable(getClearing()).ifPresent(builder::setClearing);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ClearingResultsModel _that = getType().cast(o);
		
			if (!Objects.equals(tradingEventsModel, _that.getTradingEventsModel())) return false;
			if (!Objects.equals(clearingResultsModelSequence, _that.getClearingResultsModelSequence())) return false;
			if (!Objects.equals(deClear, _that.getDeClear())) return false;
			if (!Objects.equals(clearing, _that.getClearing())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradingEventsModel != null ? tradingEventsModel.hashCode() : 0);
			_result = 31 * _result + (clearingResultsModelSequence != null ? clearingResultsModelSequence.hashCode() : 0);
			_result = 31 * _result + (deClear != null ? deClear.hashCode() : 0);
			_result = 31 * _result + (clearing != null ? clearing.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ClearingResultsModel {" +
				"tradingEventsModel=" + this.tradingEventsModel + ", " +
				"clearingResultsModelSequence=" + this.clearingResultsModelSequence + ", " +
				"deClear=" + this.deClear + ", " +
				"clearing=" + this.clearing +
			'}';
		}
	}

	/*********************** Builder Implementation of ClearingResultsModel  ***********************/
	class ClearingResultsModelBuilderImpl implements ClearingResultsModel.ClearingResultsModelBuilder {
	
		protected TradingEventsModel.TradingEventsModelBuilder tradingEventsModel;
		protected ClearingResultsModelSequence.ClearingResultsModelSequenceBuilder clearingResultsModelSequence;
		protected DeClear.DeClearBuilder deClear;
		protected Clearing.ClearingBuilder clearing;
	
		public ClearingResultsModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("tradingEventsModel")
		public TradingEventsModel.TradingEventsModelBuilder getTradingEventsModel() {
			return tradingEventsModel;
		}
		
		@Override
		public TradingEventsModel.TradingEventsModelBuilder getOrCreateTradingEventsModel() {
			TradingEventsModel.TradingEventsModelBuilder result;
			if (tradingEventsModel!=null) {
				result = tradingEventsModel;
			}
			else {
				result = tradingEventsModel = TradingEventsModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("clearingResultsModelSequence")
		public ClearingResultsModelSequence.ClearingResultsModelSequenceBuilder getClearingResultsModelSequence() {
			return clearingResultsModelSequence;
		}
		
		@Override
		public ClearingResultsModelSequence.ClearingResultsModelSequenceBuilder getOrCreateClearingResultsModelSequence() {
			ClearingResultsModelSequence.ClearingResultsModelSequenceBuilder result;
			if (clearingResultsModelSequence!=null) {
				result = clearingResultsModelSequence;
			}
			else {
				result = clearingResultsModelSequence = ClearingResultsModelSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("deClear")
		public DeClear.DeClearBuilder getDeClear() {
			return deClear;
		}
		
		@Override
		public DeClear.DeClearBuilder getOrCreateDeClear() {
			DeClear.DeClearBuilder result;
			if (deClear!=null) {
				result = deClear;
			}
			else {
				result = deClear = DeClear.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("clearing")
		public Clearing.ClearingBuilder getClearing() {
			return clearing;
		}
		
		@Override
		public Clearing.ClearingBuilder getOrCreateClearing() {
			Clearing.ClearingBuilder result;
			if (clearing!=null) {
				result = clearing;
			}
			else {
				result = clearing = Clearing.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradingEventsModel")
		public ClearingResultsModel.ClearingResultsModelBuilder setTradingEventsModel(TradingEventsModel tradingEventsModel) {
			this.tradingEventsModel = tradingEventsModel==null?null:tradingEventsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("clearingResultsModelSequence")
		public ClearingResultsModel.ClearingResultsModelBuilder setClearingResultsModelSequence(ClearingResultsModelSequence clearingResultsModelSequence) {
			this.clearingResultsModelSequence = clearingResultsModelSequence==null?null:clearingResultsModelSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("deClear")
		public ClearingResultsModel.ClearingResultsModelBuilder setDeClear(DeClear deClear) {
			this.deClear = deClear==null?null:deClear.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("clearing")
		public ClearingResultsModel.ClearingResultsModelBuilder setClearing(Clearing clearing) {
			this.clearing = clearing==null?null:clearing.toBuilder();
			return this;
		}
		
		@Override
		public ClearingResultsModel build() {
			return new ClearingResultsModel.ClearingResultsModelImpl(this);
		}
		
		@Override
		public ClearingResultsModel.ClearingResultsModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClearingResultsModel.ClearingResultsModelBuilder prune() {
			if (tradingEventsModel!=null && !tradingEventsModel.prune().hasData()) tradingEventsModel = null;
			if (clearingResultsModelSequence!=null && !clearingResultsModelSequence.prune().hasData()) clearingResultsModelSequence = null;
			if (deClear!=null && !deClear.prune().hasData()) deClear = null;
			if (clearing!=null && !clearing.prune().hasData()) clearing = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTradingEventsModel()!=null && getTradingEventsModel().hasData()) return true;
			if (getClearingResultsModelSequence()!=null && getClearingResultsModelSequence().hasData()) return true;
			if (getDeClear()!=null && getDeClear().hasData()) return true;
			if (getClearing()!=null && getClearing().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClearingResultsModel.ClearingResultsModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ClearingResultsModel.ClearingResultsModelBuilder o = (ClearingResultsModel.ClearingResultsModelBuilder) other;
			
			merger.mergeRosetta(getTradingEventsModel(), o.getTradingEventsModel(), this::setTradingEventsModel);
			merger.mergeRosetta(getClearingResultsModelSequence(), o.getClearingResultsModelSequence(), this::setClearingResultsModelSequence);
			merger.mergeRosetta(getDeClear(), o.getDeClear(), this::setDeClear);
			merger.mergeRosetta(getClearing(), o.getClearing(), this::setClearing);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ClearingResultsModel _that = getType().cast(o);
		
			if (!Objects.equals(tradingEventsModel, _that.getTradingEventsModel())) return false;
			if (!Objects.equals(clearingResultsModelSequence, _that.getClearingResultsModelSequence())) return false;
			if (!Objects.equals(deClear, _that.getDeClear())) return false;
			if (!Objects.equals(clearing, _that.getClearing())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradingEventsModel != null ? tradingEventsModel.hashCode() : 0);
			_result = 31 * _result + (clearingResultsModelSequence != null ? clearingResultsModelSequence.hashCode() : 0);
			_result = 31 * _result + (deClear != null ? deClear.hashCode() : 0);
			_result = 31 * _result + (clearing != null ? clearing.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ClearingResultsModelBuilder {" +
				"tradingEventsModel=" + this.tradingEventsModel + ", " +
				"clearingResultsModelSequence=" + this.clearingResultsModelSequence + ", " +
				"deClear=" + this.deClear + ", " +
				"clearing=" + this.clearing +
			'}';
		}
	}
}
