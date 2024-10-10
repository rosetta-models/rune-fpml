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
import fpml.confirmation.FxExchangedCurrencyModel;
import fpml.confirmation.FxSettlementAdjustmentMethodEnum;
import fpml.confirmation.FxTargetPhysicalSettlement;
import fpml.confirmation.FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilder;
import fpml.confirmation.FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilderImpl;
import fpml.confirmation.FxTargetPhysicalSettlement.FxTargetPhysicalSettlementImpl;
import fpml.confirmation.StrikeOrStrikeReferenceModel;
import fpml.confirmation.meta.FxTargetPhysicalSettlementMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FxTargetPhysicalSettlement", builder=FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilderImpl.class, version="${project.version}")
public interface FxTargetPhysicalSettlement extends RosettaModelObject {

	FxTargetPhysicalSettlementMeta metaData = new FxTargetPhysicalSettlementMeta();

	/*********************** Getter Methods  ***********************/
	FxExchangedCurrencyModel getFxExchangedCurrencyModel();
	/**
	 * The Settlement Adjustment Style can be VariedStrike or VariedNotional.
	 */
	FxSettlementAdjustmentMethodEnum getSettlementAdjustmentStyle();
	StrikeOrStrikeReferenceModel getStrikeOrStrikeReferenceModel();

	/*********************** Build Methods  ***********************/
	FxTargetPhysicalSettlement build();
	
	FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilder toBuilder();
	
	static FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilder builder() {
		return new FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxTargetPhysicalSettlement> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxTargetPhysicalSettlement> getType() {
		return FxTargetPhysicalSettlement.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("fxExchangedCurrencyModel"), processor, FxExchangedCurrencyModel.class, getFxExchangedCurrencyModel());
		processor.processBasic(path.newSubPath("settlementAdjustmentStyle"), FxSettlementAdjustmentMethodEnum.class, getSettlementAdjustmentStyle(), this);
		processRosetta(path.newSubPath("strikeOrStrikeReferenceModel"), processor, StrikeOrStrikeReferenceModel.class, getStrikeOrStrikeReferenceModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxTargetPhysicalSettlementBuilder extends FxTargetPhysicalSettlement, RosettaModelObjectBuilder {
		FxExchangedCurrencyModel.FxExchangedCurrencyModelBuilder getOrCreateFxExchangedCurrencyModel();
		FxExchangedCurrencyModel.FxExchangedCurrencyModelBuilder getFxExchangedCurrencyModel();
		StrikeOrStrikeReferenceModel.StrikeOrStrikeReferenceModelBuilder getOrCreateStrikeOrStrikeReferenceModel();
		StrikeOrStrikeReferenceModel.StrikeOrStrikeReferenceModelBuilder getStrikeOrStrikeReferenceModel();
		FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilder setFxExchangedCurrencyModel(FxExchangedCurrencyModel fxExchangedCurrencyModel);
		FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilder setSettlementAdjustmentStyle(FxSettlementAdjustmentMethodEnum settlementAdjustmentStyle);
		FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilder setStrikeOrStrikeReferenceModel(StrikeOrStrikeReferenceModel strikeOrStrikeReferenceModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("fxExchangedCurrencyModel"), processor, FxExchangedCurrencyModel.FxExchangedCurrencyModelBuilder.class, getFxExchangedCurrencyModel());
			processor.processBasic(path.newSubPath("settlementAdjustmentStyle"), FxSettlementAdjustmentMethodEnum.class, getSettlementAdjustmentStyle(), this);
			processRosetta(path.newSubPath("strikeOrStrikeReferenceModel"), processor, StrikeOrStrikeReferenceModel.StrikeOrStrikeReferenceModelBuilder.class, getStrikeOrStrikeReferenceModel());
		}
		

		FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilder prune();
	}

	/*********************** Immutable Implementation of FxTargetPhysicalSettlement  ***********************/
	class FxTargetPhysicalSettlementImpl implements FxTargetPhysicalSettlement {
		private final FxExchangedCurrencyModel fxExchangedCurrencyModel;
		private final FxSettlementAdjustmentMethodEnum settlementAdjustmentStyle;
		private final StrikeOrStrikeReferenceModel strikeOrStrikeReferenceModel;
		
		protected FxTargetPhysicalSettlementImpl(FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilder builder) {
			this.fxExchangedCurrencyModel = ofNullable(builder.getFxExchangedCurrencyModel()).map(f->f.build()).orElse(null);
			this.settlementAdjustmentStyle = builder.getSettlementAdjustmentStyle();
			this.strikeOrStrikeReferenceModel = ofNullable(builder.getStrikeOrStrikeReferenceModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("fxExchangedCurrencyModel")
		public FxExchangedCurrencyModel getFxExchangedCurrencyModel() {
			return fxExchangedCurrencyModel;
		}
		
		@Override
		@RosettaAttribute("settlementAdjustmentStyle")
		public FxSettlementAdjustmentMethodEnum getSettlementAdjustmentStyle() {
			return settlementAdjustmentStyle;
		}
		
		@Override
		@RosettaAttribute("strikeOrStrikeReferenceModel")
		public StrikeOrStrikeReferenceModel getStrikeOrStrikeReferenceModel() {
			return strikeOrStrikeReferenceModel;
		}
		
		@Override
		public FxTargetPhysicalSettlement build() {
			return this;
		}
		
		@Override
		public FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilder toBuilder() {
			FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilder builder) {
			ofNullable(getFxExchangedCurrencyModel()).ifPresent(builder::setFxExchangedCurrencyModel);
			ofNullable(getSettlementAdjustmentStyle()).ifPresent(builder::setSettlementAdjustmentStyle);
			ofNullable(getStrikeOrStrikeReferenceModel()).ifPresent(builder::setStrikeOrStrikeReferenceModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTargetPhysicalSettlement _that = getType().cast(o);
		
			if (!Objects.equals(fxExchangedCurrencyModel, _that.getFxExchangedCurrencyModel())) return false;
			if (!Objects.equals(settlementAdjustmentStyle, _that.getSettlementAdjustmentStyle())) return false;
			if (!Objects.equals(strikeOrStrikeReferenceModel, _that.getStrikeOrStrikeReferenceModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fxExchangedCurrencyModel != null ? fxExchangedCurrencyModel.hashCode() : 0);
			_result = 31 * _result + (settlementAdjustmentStyle != null ? settlementAdjustmentStyle.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (strikeOrStrikeReferenceModel != null ? strikeOrStrikeReferenceModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTargetPhysicalSettlement {" +
				"fxExchangedCurrencyModel=" + this.fxExchangedCurrencyModel + ", " +
				"settlementAdjustmentStyle=" + this.settlementAdjustmentStyle + ", " +
				"strikeOrStrikeReferenceModel=" + this.strikeOrStrikeReferenceModel +
			'}';
		}
	}

	/*********************** Builder Implementation of FxTargetPhysicalSettlement  ***********************/
	class FxTargetPhysicalSettlementBuilderImpl implements FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilder {
	
		protected FxExchangedCurrencyModel.FxExchangedCurrencyModelBuilder fxExchangedCurrencyModel;
		protected FxSettlementAdjustmentMethodEnum settlementAdjustmentStyle;
		protected StrikeOrStrikeReferenceModel.StrikeOrStrikeReferenceModelBuilder strikeOrStrikeReferenceModel;
	
		public FxTargetPhysicalSettlementBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("fxExchangedCurrencyModel")
		public FxExchangedCurrencyModel.FxExchangedCurrencyModelBuilder getFxExchangedCurrencyModel() {
			return fxExchangedCurrencyModel;
		}
		
		@Override
		public FxExchangedCurrencyModel.FxExchangedCurrencyModelBuilder getOrCreateFxExchangedCurrencyModel() {
			FxExchangedCurrencyModel.FxExchangedCurrencyModelBuilder result;
			if (fxExchangedCurrencyModel!=null) {
				result = fxExchangedCurrencyModel;
			}
			else {
				result = fxExchangedCurrencyModel = FxExchangedCurrencyModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementAdjustmentStyle")
		public FxSettlementAdjustmentMethodEnum getSettlementAdjustmentStyle() {
			return settlementAdjustmentStyle;
		}
		
		@Override
		@RosettaAttribute("strikeOrStrikeReferenceModel")
		public StrikeOrStrikeReferenceModel.StrikeOrStrikeReferenceModelBuilder getStrikeOrStrikeReferenceModel() {
			return strikeOrStrikeReferenceModel;
		}
		
		@Override
		public StrikeOrStrikeReferenceModel.StrikeOrStrikeReferenceModelBuilder getOrCreateStrikeOrStrikeReferenceModel() {
			StrikeOrStrikeReferenceModel.StrikeOrStrikeReferenceModelBuilder result;
			if (strikeOrStrikeReferenceModel!=null) {
				result = strikeOrStrikeReferenceModel;
			}
			else {
				result = strikeOrStrikeReferenceModel = StrikeOrStrikeReferenceModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fxExchangedCurrencyModel")
		public FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilder setFxExchangedCurrencyModel(FxExchangedCurrencyModel fxExchangedCurrencyModel) {
			this.fxExchangedCurrencyModel = fxExchangedCurrencyModel==null?null:fxExchangedCurrencyModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("settlementAdjustmentStyle")
		public FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilder setSettlementAdjustmentStyle(FxSettlementAdjustmentMethodEnum settlementAdjustmentStyle) {
			this.settlementAdjustmentStyle = settlementAdjustmentStyle==null?null:settlementAdjustmentStyle;
			return this;
		}
		@Override
		@RosettaAttribute("strikeOrStrikeReferenceModel")
		public FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilder setStrikeOrStrikeReferenceModel(StrikeOrStrikeReferenceModel strikeOrStrikeReferenceModel) {
			this.strikeOrStrikeReferenceModel = strikeOrStrikeReferenceModel==null?null:strikeOrStrikeReferenceModel.toBuilder();
			return this;
		}
		
		@Override
		public FxTargetPhysicalSettlement build() {
			return new FxTargetPhysicalSettlement.FxTargetPhysicalSettlementImpl(this);
		}
		
		@Override
		public FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilder prune() {
			if (fxExchangedCurrencyModel!=null && !fxExchangedCurrencyModel.prune().hasData()) fxExchangedCurrencyModel = null;
			if (strikeOrStrikeReferenceModel!=null && !strikeOrStrikeReferenceModel.prune().hasData()) strikeOrStrikeReferenceModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFxExchangedCurrencyModel()!=null && getFxExchangedCurrencyModel().hasData()) return true;
			if (getSettlementAdjustmentStyle()!=null) return true;
			if (getStrikeOrStrikeReferenceModel()!=null && getStrikeOrStrikeReferenceModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilder o = (FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilder) other;
			
			merger.mergeRosetta(getFxExchangedCurrencyModel(), o.getFxExchangedCurrencyModel(), this::setFxExchangedCurrencyModel);
			merger.mergeRosetta(getStrikeOrStrikeReferenceModel(), o.getStrikeOrStrikeReferenceModel(), this::setStrikeOrStrikeReferenceModel);
			
			merger.mergeBasic(getSettlementAdjustmentStyle(), o.getSettlementAdjustmentStyle(), this::setSettlementAdjustmentStyle);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTargetPhysicalSettlement _that = getType().cast(o);
		
			if (!Objects.equals(fxExchangedCurrencyModel, _that.getFxExchangedCurrencyModel())) return false;
			if (!Objects.equals(settlementAdjustmentStyle, _that.getSettlementAdjustmentStyle())) return false;
			if (!Objects.equals(strikeOrStrikeReferenceModel, _that.getStrikeOrStrikeReferenceModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fxExchangedCurrencyModel != null ? fxExchangedCurrencyModel.hashCode() : 0);
			_result = 31 * _result + (settlementAdjustmentStyle != null ? settlementAdjustmentStyle.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (strikeOrStrikeReferenceModel != null ? strikeOrStrikeReferenceModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTargetPhysicalSettlementBuilder {" +
				"fxExchangedCurrencyModel=" + this.fxExchangedCurrencyModel + ", " +
				"settlementAdjustmentStyle=" + this.settlementAdjustmentStyle + ", " +
				"strikeOrStrikeReferenceModel=" + this.strikeOrStrikeReferenceModel +
			'}';
		}
	}
}
