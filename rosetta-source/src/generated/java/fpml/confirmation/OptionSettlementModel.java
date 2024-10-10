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
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.OptionSettlementModel;
import fpml.confirmation.OptionSettlementModel.OptionSettlementModelBuilder;
import fpml.confirmation.OptionSettlementModel.OptionSettlementModelBuilderImpl;
import fpml.confirmation.OptionSettlementModel.OptionSettlementModelImpl;
import fpml.confirmation.SettlementAmountOrCurrencyModel;
import fpml.confirmation.SettlementTypeEnum;
import fpml.confirmation.meta.OptionSettlementModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A group which has Option Settlement elements.
 * @version ${project.version}
 */
@RosettaDataType(value="OptionSettlementModel", builder=OptionSettlementModel.OptionSettlementModelBuilderImpl.class, version="${project.version}")
public interface OptionSettlementModel extends RosettaModelObject {

	OptionSettlementModelMeta metaData = new OptionSettlementModelMeta();

	/*********************** Getter Methods  ***********************/
	SettlementTypeEnum getSettlementType();
	AdjustableOrRelativeDate getSettlementDate();
	SettlementAmountOrCurrencyModel getSettlementAmountOrCurrencyModel();

	/*********************** Build Methods  ***********************/
	OptionSettlementModel build();
	
	OptionSettlementModel.OptionSettlementModelBuilder toBuilder();
	
	static OptionSettlementModel.OptionSettlementModelBuilder builder() {
		return new OptionSettlementModel.OptionSettlementModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OptionSettlementModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends OptionSettlementModel> getType() {
		return OptionSettlementModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("settlementType"), SettlementTypeEnum.class, getSettlementType(), this);
		processRosetta(path.newSubPath("settlementDate"), processor, AdjustableOrRelativeDate.class, getSettlementDate());
		processRosetta(path.newSubPath("settlementAmountOrCurrencyModel"), processor, SettlementAmountOrCurrencyModel.class, getSettlementAmountOrCurrencyModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface OptionSettlementModelBuilder extends OptionSettlementModel, RosettaModelObjectBuilder {
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateSettlementDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getSettlementDate();
		SettlementAmountOrCurrencyModel.SettlementAmountOrCurrencyModelBuilder getOrCreateSettlementAmountOrCurrencyModel();
		SettlementAmountOrCurrencyModel.SettlementAmountOrCurrencyModelBuilder getSettlementAmountOrCurrencyModel();
		OptionSettlementModel.OptionSettlementModelBuilder setSettlementType(SettlementTypeEnum settlementType);
		OptionSettlementModel.OptionSettlementModelBuilder setSettlementDate(AdjustableOrRelativeDate settlementDate);
		OptionSettlementModel.OptionSettlementModelBuilder setSettlementAmountOrCurrencyModel(SettlementAmountOrCurrencyModel settlementAmountOrCurrencyModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("settlementType"), SettlementTypeEnum.class, getSettlementType(), this);
			processRosetta(path.newSubPath("settlementDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getSettlementDate());
			processRosetta(path.newSubPath("settlementAmountOrCurrencyModel"), processor, SettlementAmountOrCurrencyModel.SettlementAmountOrCurrencyModelBuilder.class, getSettlementAmountOrCurrencyModel());
		}
		

		OptionSettlementModel.OptionSettlementModelBuilder prune();
	}

	/*********************** Immutable Implementation of OptionSettlementModel  ***********************/
	class OptionSettlementModelImpl implements OptionSettlementModel {
		private final SettlementTypeEnum settlementType;
		private final AdjustableOrRelativeDate settlementDate;
		private final SettlementAmountOrCurrencyModel settlementAmountOrCurrencyModel;
		
		protected OptionSettlementModelImpl(OptionSettlementModel.OptionSettlementModelBuilder builder) {
			this.settlementType = builder.getSettlementType();
			this.settlementDate = ofNullable(builder.getSettlementDate()).map(f->f.build()).orElse(null);
			this.settlementAmountOrCurrencyModel = ofNullable(builder.getSettlementAmountOrCurrencyModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("settlementType")
		public SettlementTypeEnum getSettlementType() {
			return settlementType;
		}
		
		@Override
		@RosettaAttribute("settlementDate")
		public AdjustableOrRelativeDate getSettlementDate() {
			return settlementDate;
		}
		
		@Override
		@RosettaAttribute("settlementAmountOrCurrencyModel")
		public SettlementAmountOrCurrencyModel getSettlementAmountOrCurrencyModel() {
			return settlementAmountOrCurrencyModel;
		}
		
		@Override
		public OptionSettlementModel build() {
			return this;
		}
		
		@Override
		public OptionSettlementModel.OptionSettlementModelBuilder toBuilder() {
			OptionSettlementModel.OptionSettlementModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OptionSettlementModel.OptionSettlementModelBuilder builder) {
			ofNullable(getSettlementType()).ifPresent(builder::setSettlementType);
			ofNullable(getSettlementDate()).ifPresent(builder::setSettlementDate);
			ofNullable(getSettlementAmountOrCurrencyModel()).ifPresent(builder::setSettlementAmountOrCurrencyModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionSettlementModel _that = getType().cast(o);
		
			if (!Objects.equals(settlementType, _that.getSettlementType())) return false;
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			if (!Objects.equals(settlementAmountOrCurrencyModel, _that.getSettlementAmountOrCurrencyModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (settlementType != null ? settlementType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			_result = 31 * _result + (settlementAmountOrCurrencyModel != null ? settlementAmountOrCurrencyModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionSettlementModel {" +
				"settlementType=" + this.settlementType + ", " +
				"settlementDate=" + this.settlementDate + ", " +
				"settlementAmountOrCurrencyModel=" + this.settlementAmountOrCurrencyModel +
			'}';
		}
	}

	/*********************** Builder Implementation of OptionSettlementModel  ***********************/
	class OptionSettlementModelBuilderImpl implements OptionSettlementModel.OptionSettlementModelBuilder {
	
		protected SettlementTypeEnum settlementType;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder settlementDate;
		protected SettlementAmountOrCurrencyModel.SettlementAmountOrCurrencyModelBuilder settlementAmountOrCurrencyModel;
	
		public OptionSettlementModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("settlementType")
		public SettlementTypeEnum getSettlementType() {
			return settlementType;
		}
		
		@Override
		@RosettaAttribute("settlementDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getSettlementDate() {
			return settlementDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateSettlementDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (settlementDate!=null) {
				result = settlementDate;
			}
			else {
				result = settlementDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementAmountOrCurrencyModel")
		public SettlementAmountOrCurrencyModel.SettlementAmountOrCurrencyModelBuilder getSettlementAmountOrCurrencyModel() {
			return settlementAmountOrCurrencyModel;
		}
		
		@Override
		public SettlementAmountOrCurrencyModel.SettlementAmountOrCurrencyModelBuilder getOrCreateSettlementAmountOrCurrencyModel() {
			SettlementAmountOrCurrencyModel.SettlementAmountOrCurrencyModelBuilder result;
			if (settlementAmountOrCurrencyModel!=null) {
				result = settlementAmountOrCurrencyModel;
			}
			else {
				result = settlementAmountOrCurrencyModel = SettlementAmountOrCurrencyModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementType")
		public OptionSettlementModel.OptionSettlementModelBuilder setSettlementType(SettlementTypeEnum settlementType) {
			this.settlementType = settlementType==null?null:settlementType;
			return this;
		}
		@Override
		@RosettaAttribute("settlementDate")
		public OptionSettlementModel.OptionSettlementModelBuilder setSettlementDate(AdjustableOrRelativeDate settlementDate) {
			this.settlementDate = settlementDate==null?null:settlementDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("settlementAmountOrCurrencyModel")
		public OptionSettlementModel.OptionSettlementModelBuilder setSettlementAmountOrCurrencyModel(SettlementAmountOrCurrencyModel settlementAmountOrCurrencyModel) {
			this.settlementAmountOrCurrencyModel = settlementAmountOrCurrencyModel==null?null:settlementAmountOrCurrencyModel.toBuilder();
			return this;
		}
		
		@Override
		public OptionSettlementModel build() {
			return new OptionSettlementModel.OptionSettlementModelImpl(this);
		}
		
		@Override
		public OptionSettlementModel.OptionSettlementModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionSettlementModel.OptionSettlementModelBuilder prune() {
			if (settlementDate!=null && !settlementDate.prune().hasData()) settlementDate = null;
			if (settlementAmountOrCurrencyModel!=null && !settlementAmountOrCurrencyModel.prune().hasData()) settlementAmountOrCurrencyModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSettlementType()!=null) return true;
			if (getSettlementDate()!=null && getSettlementDate().hasData()) return true;
			if (getSettlementAmountOrCurrencyModel()!=null && getSettlementAmountOrCurrencyModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionSettlementModel.OptionSettlementModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OptionSettlementModel.OptionSettlementModelBuilder o = (OptionSettlementModel.OptionSettlementModelBuilder) other;
			
			merger.mergeRosetta(getSettlementDate(), o.getSettlementDate(), this::setSettlementDate);
			merger.mergeRosetta(getSettlementAmountOrCurrencyModel(), o.getSettlementAmountOrCurrencyModel(), this::setSettlementAmountOrCurrencyModel);
			
			merger.mergeBasic(getSettlementType(), o.getSettlementType(), this::setSettlementType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionSettlementModel _that = getType().cast(o);
		
			if (!Objects.equals(settlementType, _that.getSettlementType())) return false;
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			if (!Objects.equals(settlementAmountOrCurrencyModel, _that.getSettlementAmountOrCurrencyModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (settlementType != null ? settlementType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			_result = 31 * _result + (settlementAmountOrCurrencyModel != null ? settlementAmountOrCurrencyModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionSettlementModelBuilder {" +
				"settlementType=" + this.settlementType + ", " +
				"settlementDate=" + this.settlementDate + ", " +
				"settlementAmountOrCurrencyModel=" + this.settlementAmountOrCurrencyModel +
			'}';
		}
	}
}
