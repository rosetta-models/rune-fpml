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
import fpml.confirmation.TradeLegFixedAmountChangeModel;
import fpml.confirmation.TradeLegNotionalChangeModel;
import fpml.confirmation.TradeLegNotionalScheduleChangeModel;
import fpml.confirmation.TradeLegNumberOfOptionsChangeModel;
import fpml.confirmation.TradeLegNumberOfUnitsChangeModel;
import fpml.confirmation.TradeLegSizeChange;
import fpml.confirmation.TradeLegSizeChange.TradeLegSizeChangeBuilder;
import fpml.confirmation.TradeLegSizeChange.TradeLegSizeChangeBuilderImpl;
import fpml.confirmation.TradeLegSizeChange.TradeLegSizeChangeImpl;
import fpml.confirmation.meta.TradeLegSizeChangeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A structure describing a change to the size of a single leg or stream of a trade.
 * @version ${project.version}
 */
@RosettaDataType(value="TradeLegSizeChange", builder=TradeLegSizeChange.TradeLegSizeChangeBuilderImpl.class, version="${project.version}")
public interface TradeLegSizeChange extends RosettaModelObject {

	TradeLegSizeChangeMeta metaData = new TradeLegSizeChangeMeta();

	/*********************** Getter Methods  ***********************/
	TradeLegNotionalChangeModel getTradeLegNotionalChangeModel();
	TradeLegNumberOfOptionsChangeModel getTradeLegNumberOfOptionsChangeModel();
	TradeLegNumberOfUnitsChangeModel getTradeLegNumberOfUnitsChangeModel();
	TradeLegNotionalScheduleChangeModel getTradeLegNotionalScheduleChangeModel();
	TradeLegFixedAmountChangeModel getTradeLegFixedAmountChangeModel();

	/*********************** Build Methods  ***********************/
	TradeLegSizeChange build();
	
	TradeLegSizeChange.TradeLegSizeChangeBuilder toBuilder();
	
	static TradeLegSizeChange.TradeLegSizeChangeBuilder builder() {
		return new TradeLegSizeChange.TradeLegSizeChangeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeLegSizeChange> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TradeLegSizeChange> getType() {
		return TradeLegSizeChange.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("tradeLegNotionalChangeModel"), processor, TradeLegNotionalChangeModel.class, getTradeLegNotionalChangeModel());
		processRosetta(path.newSubPath("tradeLegNumberOfOptionsChangeModel"), processor, TradeLegNumberOfOptionsChangeModel.class, getTradeLegNumberOfOptionsChangeModel());
		processRosetta(path.newSubPath("tradeLegNumberOfUnitsChangeModel"), processor, TradeLegNumberOfUnitsChangeModel.class, getTradeLegNumberOfUnitsChangeModel());
		processRosetta(path.newSubPath("tradeLegNotionalScheduleChangeModel"), processor, TradeLegNotionalScheduleChangeModel.class, getTradeLegNotionalScheduleChangeModel());
		processRosetta(path.newSubPath("tradeLegFixedAmountChangeModel"), processor, TradeLegFixedAmountChangeModel.class, getTradeLegFixedAmountChangeModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeLegSizeChangeBuilder extends TradeLegSizeChange, RosettaModelObjectBuilder {
		TradeLegNotionalChangeModel.TradeLegNotionalChangeModelBuilder getOrCreateTradeLegNotionalChangeModel();
		TradeLegNotionalChangeModel.TradeLegNotionalChangeModelBuilder getTradeLegNotionalChangeModel();
		TradeLegNumberOfOptionsChangeModel.TradeLegNumberOfOptionsChangeModelBuilder getOrCreateTradeLegNumberOfOptionsChangeModel();
		TradeLegNumberOfOptionsChangeModel.TradeLegNumberOfOptionsChangeModelBuilder getTradeLegNumberOfOptionsChangeModel();
		TradeLegNumberOfUnitsChangeModel.TradeLegNumberOfUnitsChangeModelBuilder getOrCreateTradeLegNumberOfUnitsChangeModel();
		TradeLegNumberOfUnitsChangeModel.TradeLegNumberOfUnitsChangeModelBuilder getTradeLegNumberOfUnitsChangeModel();
		TradeLegNotionalScheduleChangeModel.TradeLegNotionalScheduleChangeModelBuilder getOrCreateTradeLegNotionalScheduleChangeModel();
		TradeLegNotionalScheduleChangeModel.TradeLegNotionalScheduleChangeModelBuilder getTradeLegNotionalScheduleChangeModel();
		TradeLegFixedAmountChangeModel.TradeLegFixedAmountChangeModelBuilder getOrCreateTradeLegFixedAmountChangeModel();
		TradeLegFixedAmountChangeModel.TradeLegFixedAmountChangeModelBuilder getTradeLegFixedAmountChangeModel();
		TradeLegSizeChange.TradeLegSizeChangeBuilder setTradeLegNotionalChangeModel(TradeLegNotionalChangeModel tradeLegNotionalChangeModel);
		TradeLegSizeChange.TradeLegSizeChangeBuilder setTradeLegNumberOfOptionsChangeModel(TradeLegNumberOfOptionsChangeModel tradeLegNumberOfOptionsChangeModel);
		TradeLegSizeChange.TradeLegSizeChangeBuilder setTradeLegNumberOfUnitsChangeModel(TradeLegNumberOfUnitsChangeModel tradeLegNumberOfUnitsChangeModel);
		TradeLegSizeChange.TradeLegSizeChangeBuilder setTradeLegNotionalScheduleChangeModel(TradeLegNotionalScheduleChangeModel tradeLegNotionalScheduleChangeModel);
		TradeLegSizeChange.TradeLegSizeChangeBuilder setTradeLegFixedAmountChangeModel(TradeLegFixedAmountChangeModel tradeLegFixedAmountChangeModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("tradeLegNotionalChangeModel"), processor, TradeLegNotionalChangeModel.TradeLegNotionalChangeModelBuilder.class, getTradeLegNotionalChangeModel());
			processRosetta(path.newSubPath("tradeLegNumberOfOptionsChangeModel"), processor, TradeLegNumberOfOptionsChangeModel.TradeLegNumberOfOptionsChangeModelBuilder.class, getTradeLegNumberOfOptionsChangeModel());
			processRosetta(path.newSubPath("tradeLegNumberOfUnitsChangeModel"), processor, TradeLegNumberOfUnitsChangeModel.TradeLegNumberOfUnitsChangeModelBuilder.class, getTradeLegNumberOfUnitsChangeModel());
			processRosetta(path.newSubPath("tradeLegNotionalScheduleChangeModel"), processor, TradeLegNotionalScheduleChangeModel.TradeLegNotionalScheduleChangeModelBuilder.class, getTradeLegNotionalScheduleChangeModel());
			processRosetta(path.newSubPath("tradeLegFixedAmountChangeModel"), processor, TradeLegFixedAmountChangeModel.TradeLegFixedAmountChangeModelBuilder.class, getTradeLegFixedAmountChangeModel());
		}
		

		TradeLegSizeChange.TradeLegSizeChangeBuilder prune();
	}

	/*********************** Immutable Implementation of TradeLegSizeChange  ***********************/
	class TradeLegSizeChangeImpl implements TradeLegSizeChange {
		private final TradeLegNotionalChangeModel tradeLegNotionalChangeModel;
		private final TradeLegNumberOfOptionsChangeModel tradeLegNumberOfOptionsChangeModel;
		private final TradeLegNumberOfUnitsChangeModel tradeLegNumberOfUnitsChangeModel;
		private final TradeLegNotionalScheduleChangeModel tradeLegNotionalScheduleChangeModel;
		private final TradeLegFixedAmountChangeModel tradeLegFixedAmountChangeModel;
		
		protected TradeLegSizeChangeImpl(TradeLegSizeChange.TradeLegSizeChangeBuilder builder) {
			this.tradeLegNotionalChangeModel = ofNullable(builder.getTradeLegNotionalChangeModel()).map(f->f.build()).orElse(null);
			this.tradeLegNumberOfOptionsChangeModel = ofNullable(builder.getTradeLegNumberOfOptionsChangeModel()).map(f->f.build()).orElse(null);
			this.tradeLegNumberOfUnitsChangeModel = ofNullable(builder.getTradeLegNumberOfUnitsChangeModel()).map(f->f.build()).orElse(null);
			this.tradeLegNotionalScheduleChangeModel = ofNullable(builder.getTradeLegNotionalScheduleChangeModel()).map(f->f.build()).orElse(null);
			this.tradeLegFixedAmountChangeModel = ofNullable(builder.getTradeLegFixedAmountChangeModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("tradeLegNotionalChangeModel")
		public TradeLegNotionalChangeModel getTradeLegNotionalChangeModel() {
			return tradeLegNotionalChangeModel;
		}
		
		@Override
		@RosettaAttribute("tradeLegNumberOfOptionsChangeModel")
		public TradeLegNumberOfOptionsChangeModel getTradeLegNumberOfOptionsChangeModel() {
			return tradeLegNumberOfOptionsChangeModel;
		}
		
		@Override
		@RosettaAttribute("tradeLegNumberOfUnitsChangeModel")
		public TradeLegNumberOfUnitsChangeModel getTradeLegNumberOfUnitsChangeModel() {
			return tradeLegNumberOfUnitsChangeModel;
		}
		
		@Override
		@RosettaAttribute("tradeLegNotionalScheduleChangeModel")
		public TradeLegNotionalScheduleChangeModel getTradeLegNotionalScheduleChangeModel() {
			return tradeLegNotionalScheduleChangeModel;
		}
		
		@Override
		@RosettaAttribute("tradeLegFixedAmountChangeModel")
		public TradeLegFixedAmountChangeModel getTradeLegFixedAmountChangeModel() {
			return tradeLegFixedAmountChangeModel;
		}
		
		@Override
		public TradeLegSizeChange build() {
			return this;
		}
		
		@Override
		public TradeLegSizeChange.TradeLegSizeChangeBuilder toBuilder() {
			TradeLegSizeChange.TradeLegSizeChangeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeLegSizeChange.TradeLegSizeChangeBuilder builder) {
			ofNullable(getTradeLegNotionalChangeModel()).ifPresent(builder::setTradeLegNotionalChangeModel);
			ofNullable(getTradeLegNumberOfOptionsChangeModel()).ifPresent(builder::setTradeLegNumberOfOptionsChangeModel);
			ofNullable(getTradeLegNumberOfUnitsChangeModel()).ifPresent(builder::setTradeLegNumberOfUnitsChangeModel);
			ofNullable(getTradeLegNotionalScheduleChangeModel()).ifPresent(builder::setTradeLegNotionalScheduleChangeModel);
			ofNullable(getTradeLegFixedAmountChangeModel()).ifPresent(builder::setTradeLegFixedAmountChangeModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeLegSizeChange _that = getType().cast(o);
		
			if (!Objects.equals(tradeLegNotionalChangeModel, _that.getTradeLegNotionalChangeModel())) return false;
			if (!Objects.equals(tradeLegNumberOfOptionsChangeModel, _that.getTradeLegNumberOfOptionsChangeModel())) return false;
			if (!Objects.equals(tradeLegNumberOfUnitsChangeModel, _that.getTradeLegNumberOfUnitsChangeModel())) return false;
			if (!Objects.equals(tradeLegNotionalScheduleChangeModel, _that.getTradeLegNotionalScheduleChangeModel())) return false;
			if (!Objects.equals(tradeLegFixedAmountChangeModel, _that.getTradeLegFixedAmountChangeModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradeLegNotionalChangeModel != null ? tradeLegNotionalChangeModel.hashCode() : 0);
			_result = 31 * _result + (tradeLegNumberOfOptionsChangeModel != null ? tradeLegNumberOfOptionsChangeModel.hashCode() : 0);
			_result = 31 * _result + (tradeLegNumberOfUnitsChangeModel != null ? tradeLegNumberOfUnitsChangeModel.hashCode() : 0);
			_result = 31 * _result + (tradeLegNotionalScheduleChangeModel != null ? tradeLegNotionalScheduleChangeModel.hashCode() : 0);
			_result = 31 * _result + (tradeLegFixedAmountChangeModel != null ? tradeLegFixedAmountChangeModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeLegSizeChange {" +
				"tradeLegNotionalChangeModel=" + this.tradeLegNotionalChangeModel + ", " +
				"tradeLegNumberOfOptionsChangeModel=" + this.tradeLegNumberOfOptionsChangeModel + ", " +
				"tradeLegNumberOfUnitsChangeModel=" + this.tradeLegNumberOfUnitsChangeModel + ", " +
				"tradeLegNotionalScheduleChangeModel=" + this.tradeLegNotionalScheduleChangeModel + ", " +
				"tradeLegFixedAmountChangeModel=" + this.tradeLegFixedAmountChangeModel +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeLegSizeChange  ***********************/
	class TradeLegSizeChangeBuilderImpl implements TradeLegSizeChange.TradeLegSizeChangeBuilder {
	
		protected TradeLegNotionalChangeModel.TradeLegNotionalChangeModelBuilder tradeLegNotionalChangeModel;
		protected TradeLegNumberOfOptionsChangeModel.TradeLegNumberOfOptionsChangeModelBuilder tradeLegNumberOfOptionsChangeModel;
		protected TradeLegNumberOfUnitsChangeModel.TradeLegNumberOfUnitsChangeModelBuilder tradeLegNumberOfUnitsChangeModel;
		protected TradeLegNotionalScheduleChangeModel.TradeLegNotionalScheduleChangeModelBuilder tradeLegNotionalScheduleChangeModel;
		protected TradeLegFixedAmountChangeModel.TradeLegFixedAmountChangeModelBuilder tradeLegFixedAmountChangeModel;
	
		public TradeLegSizeChangeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("tradeLegNotionalChangeModel")
		public TradeLegNotionalChangeModel.TradeLegNotionalChangeModelBuilder getTradeLegNotionalChangeModel() {
			return tradeLegNotionalChangeModel;
		}
		
		@Override
		public TradeLegNotionalChangeModel.TradeLegNotionalChangeModelBuilder getOrCreateTradeLegNotionalChangeModel() {
			TradeLegNotionalChangeModel.TradeLegNotionalChangeModelBuilder result;
			if (tradeLegNotionalChangeModel!=null) {
				result = tradeLegNotionalChangeModel;
			}
			else {
				result = tradeLegNotionalChangeModel = TradeLegNotionalChangeModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradeLegNumberOfOptionsChangeModel")
		public TradeLegNumberOfOptionsChangeModel.TradeLegNumberOfOptionsChangeModelBuilder getTradeLegNumberOfOptionsChangeModel() {
			return tradeLegNumberOfOptionsChangeModel;
		}
		
		@Override
		public TradeLegNumberOfOptionsChangeModel.TradeLegNumberOfOptionsChangeModelBuilder getOrCreateTradeLegNumberOfOptionsChangeModel() {
			TradeLegNumberOfOptionsChangeModel.TradeLegNumberOfOptionsChangeModelBuilder result;
			if (tradeLegNumberOfOptionsChangeModel!=null) {
				result = tradeLegNumberOfOptionsChangeModel;
			}
			else {
				result = tradeLegNumberOfOptionsChangeModel = TradeLegNumberOfOptionsChangeModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradeLegNumberOfUnitsChangeModel")
		public TradeLegNumberOfUnitsChangeModel.TradeLegNumberOfUnitsChangeModelBuilder getTradeLegNumberOfUnitsChangeModel() {
			return tradeLegNumberOfUnitsChangeModel;
		}
		
		@Override
		public TradeLegNumberOfUnitsChangeModel.TradeLegNumberOfUnitsChangeModelBuilder getOrCreateTradeLegNumberOfUnitsChangeModel() {
			TradeLegNumberOfUnitsChangeModel.TradeLegNumberOfUnitsChangeModelBuilder result;
			if (tradeLegNumberOfUnitsChangeModel!=null) {
				result = tradeLegNumberOfUnitsChangeModel;
			}
			else {
				result = tradeLegNumberOfUnitsChangeModel = TradeLegNumberOfUnitsChangeModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradeLegNotionalScheduleChangeModel")
		public TradeLegNotionalScheduleChangeModel.TradeLegNotionalScheduleChangeModelBuilder getTradeLegNotionalScheduleChangeModel() {
			return tradeLegNotionalScheduleChangeModel;
		}
		
		@Override
		public TradeLegNotionalScheduleChangeModel.TradeLegNotionalScheduleChangeModelBuilder getOrCreateTradeLegNotionalScheduleChangeModel() {
			TradeLegNotionalScheduleChangeModel.TradeLegNotionalScheduleChangeModelBuilder result;
			if (tradeLegNotionalScheduleChangeModel!=null) {
				result = tradeLegNotionalScheduleChangeModel;
			}
			else {
				result = tradeLegNotionalScheduleChangeModel = TradeLegNotionalScheduleChangeModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradeLegFixedAmountChangeModel")
		public TradeLegFixedAmountChangeModel.TradeLegFixedAmountChangeModelBuilder getTradeLegFixedAmountChangeModel() {
			return tradeLegFixedAmountChangeModel;
		}
		
		@Override
		public TradeLegFixedAmountChangeModel.TradeLegFixedAmountChangeModelBuilder getOrCreateTradeLegFixedAmountChangeModel() {
			TradeLegFixedAmountChangeModel.TradeLegFixedAmountChangeModelBuilder result;
			if (tradeLegFixedAmountChangeModel!=null) {
				result = tradeLegFixedAmountChangeModel;
			}
			else {
				result = tradeLegFixedAmountChangeModel = TradeLegFixedAmountChangeModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradeLegNotionalChangeModel")
		public TradeLegSizeChange.TradeLegSizeChangeBuilder setTradeLegNotionalChangeModel(TradeLegNotionalChangeModel tradeLegNotionalChangeModel) {
			this.tradeLegNotionalChangeModel = tradeLegNotionalChangeModel==null?null:tradeLegNotionalChangeModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tradeLegNumberOfOptionsChangeModel")
		public TradeLegSizeChange.TradeLegSizeChangeBuilder setTradeLegNumberOfOptionsChangeModel(TradeLegNumberOfOptionsChangeModel tradeLegNumberOfOptionsChangeModel) {
			this.tradeLegNumberOfOptionsChangeModel = tradeLegNumberOfOptionsChangeModel==null?null:tradeLegNumberOfOptionsChangeModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tradeLegNumberOfUnitsChangeModel")
		public TradeLegSizeChange.TradeLegSizeChangeBuilder setTradeLegNumberOfUnitsChangeModel(TradeLegNumberOfUnitsChangeModel tradeLegNumberOfUnitsChangeModel) {
			this.tradeLegNumberOfUnitsChangeModel = tradeLegNumberOfUnitsChangeModel==null?null:tradeLegNumberOfUnitsChangeModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tradeLegNotionalScheduleChangeModel")
		public TradeLegSizeChange.TradeLegSizeChangeBuilder setTradeLegNotionalScheduleChangeModel(TradeLegNotionalScheduleChangeModel tradeLegNotionalScheduleChangeModel) {
			this.tradeLegNotionalScheduleChangeModel = tradeLegNotionalScheduleChangeModel==null?null:tradeLegNotionalScheduleChangeModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tradeLegFixedAmountChangeModel")
		public TradeLegSizeChange.TradeLegSizeChangeBuilder setTradeLegFixedAmountChangeModel(TradeLegFixedAmountChangeModel tradeLegFixedAmountChangeModel) {
			this.tradeLegFixedAmountChangeModel = tradeLegFixedAmountChangeModel==null?null:tradeLegFixedAmountChangeModel.toBuilder();
			return this;
		}
		
		@Override
		public TradeLegSizeChange build() {
			return new TradeLegSizeChange.TradeLegSizeChangeImpl(this);
		}
		
		@Override
		public TradeLegSizeChange.TradeLegSizeChangeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeLegSizeChange.TradeLegSizeChangeBuilder prune() {
			if (tradeLegNotionalChangeModel!=null && !tradeLegNotionalChangeModel.prune().hasData()) tradeLegNotionalChangeModel = null;
			if (tradeLegNumberOfOptionsChangeModel!=null && !tradeLegNumberOfOptionsChangeModel.prune().hasData()) tradeLegNumberOfOptionsChangeModel = null;
			if (tradeLegNumberOfUnitsChangeModel!=null && !tradeLegNumberOfUnitsChangeModel.prune().hasData()) tradeLegNumberOfUnitsChangeModel = null;
			if (tradeLegNotionalScheduleChangeModel!=null && !tradeLegNotionalScheduleChangeModel.prune().hasData()) tradeLegNotionalScheduleChangeModel = null;
			if (tradeLegFixedAmountChangeModel!=null && !tradeLegFixedAmountChangeModel.prune().hasData()) tradeLegFixedAmountChangeModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTradeLegNotionalChangeModel()!=null && getTradeLegNotionalChangeModel().hasData()) return true;
			if (getTradeLegNumberOfOptionsChangeModel()!=null && getTradeLegNumberOfOptionsChangeModel().hasData()) return true;
			if (getTradeLegNumberOfUnitsChangeModel()!=null && getTradeLegNumberOfUnitsChangeModel().hasData()) return true;
			if (getTradeLegNotionalScheduleChangeModel()!=null && getTradeLegNotionalScheduleChangeModel().hasData()) return true;
			if (getTradeLegFixedAmountChangeModel()!=null && getTradeLegFixedAmountChangeModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeLegSizeChange.TradeLegSizeChangeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeLegSizeChange.TradeLegSizeChangeBuilder o = (TradeLegSizeChange.TradeLegSizeChangeBuilder) other;
			
			merger.mergeRosetta(getTradeLegNotionalChangeModel(), o.getTradeLegNotionalChangeModel(), this::setTradeLegNotionalChangeModel);
			merger.mergeRosetta(getTradeLegNumberOfOptionsChangeModel(), o.getTradeLegNumberOfOptionsChangeModel(), this::setTradeLegNumberOfOptionsChangeModel);
			merger.mergeRosetta(getTradeLegNumberOfUnitsChangeModel(), o.getTradeLegNumberOfUnitsChangeModel(), this::setTradeLegNumberOfUnitsChangeModel);
			merger.mergeRosetta(getTradeLegNotionalScheduleChangeModel(), o.getTradeLegNotionalScheduleChangeModel(), this::setTradeLegNotionalScheduleChangeModel);
			merger.mergeRosetta(getTradeLegFixedAmountChangeModel(), o.getTradeLegFixedAmountChangeModel(), this::setTradeLegFixedAmountChangeModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeLegSizeChange _that = getType().cast(o);
		
			if (!Objects.equals(tradeLegNotionalChangeModel, _that.getTradeLegNotionalChangeModel())) return false;
			if (!Objects.equals(tradeLegNumberOfOptionsChangeModel, _that.getTradeLegNumberOfOptionsChangeModel())) return false;
			if (!Objects.equals(tradeLegNumberOfUnitsChangeModel, _that.getTradeLegNumberOfUnitsChangeModel())) return false;
			if (!Objects.equals(tradeLegNotionalScheduleChangeModel, _that.getTradeLegNotionalScheduleChangeModel())) return false;
			if (!Objects.equals(tradeLegFixedAmountChangeModel, _that.getTradeLegFixedAmountChangeModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradeLegNotionalChangeModel != null ? tradeLegNotionalChangeModel.hashCode() : 0);
			_result = 31 * _result + (tradeLegNumberOfOptionsChangeModel != null ? tradeLegNumberOfOptionsChangeModel.hashCode() : 0);
			_result = 31 * _result + (tradeLegNumberOfUnitsChangeModel != null ? tradeLegNumberOfUnitsChangeModel.hashCode() : 0);
			_result = 31 * _result + (tradeLegNotionalScheduleChangeModel != null ? tradeLegNotionalScheduleChangeModel.hashCode() : 0);
			_result = 31 * _result + (tradeLegFixedAmountChangeModel != null ? tradeLegFixedAmountChangeModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeLegSizeChangeBuilder {" +
				"tradeLegNotionalChangeModel=" + this.tradeLegNotionalChangeModel + ", " +
				"tradeLegNumberOfOptionsChangeModel=" + this.tradeLegNumberOfOptionsChangeModel + ", " +
				"tradeLegNumberOfUnitsChangeModel=" + this.tradeLegNumberOfUnitsChangeModel + ", " +
				"tradeLegNotionalScheduleChangeModel=" + this.tradeLegNotionalScheduleChangeModel + ", " +
				"tradeLegFixedAmountChangeModel=" + this.tradeLegFixedAmountChangeModel +
			'}';
		}
	}
}
