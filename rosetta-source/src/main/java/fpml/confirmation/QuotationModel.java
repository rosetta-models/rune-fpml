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
import fpml.confirmation.QuotationCharacteristicsModel;
import fpml.confirmation.QuotationModel;
import fpml.confirmation.QuotationModel.QuotationModelBuilder;
import fpml.confirmation.QuotationModel.QuotationModelBuilderImpl;
import fpml.confirmation.QuotationModel.QuotationModelImpl;
import fpml.confirmation.meta.QuotationModelMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Some kind of numerical measure about an asset, eg. its price or NPV, together with characteristics of that measure.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="QuotationModel", builder=QuotationModel.QuotationModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface QuotationModel extends RosettaModelObject {

	QuotationModelMeta metaData = new QuotationModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The value of the the quotation.
	 */
	BigDecimal getValue();
	QuotationCharacteristicsModel getQuotationCharacteristicsModel();

	/*********************** Build Methods  ***********************/
	QuotationModel build();
	
	QuotationModel.QuotationModelBuilder toBuilder();
	
	static QuotationModel.QuotationModelBuilder builder() {
		return new QuotationModel.QuotationModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends QuotationModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends QuotationModel> getType() {
		return QuotationModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), BigDecimal.class, getValue(), this);
		processRosetta(path.newSubPath("quotationCharacteristicsModel"), processor, QuotationCharacteristicsModel.class, getQuotationCharacteristicsModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface QuotationModelBuilder extends QuotationModel, RosettaModelObjectBuilder {
		QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder getOrCreateQuotationCharacteristicsModel();
		QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder getQuotationCharacteristicsModel();
		QuotationModel.QuotationModelBuilder setValue(BigDecimal value);
		QuotationModel.QuotationModelBuilder setQuotationCharacteristicsModel(QuotationCharacteristicsModel quotationCharacteristicsModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), BigDecimal.class, getValue(), this);
			processRosetta(path.newSubPath("quotationCharacteristicsModel"), processor, QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder.class, getQuotationCharacteristicsModel());
		}
		

		QuotationModel.QuotationModelBuilder prune();
	}

	/*********************** Immutable Implementation of QuotationModel  ***********************/
	class QuotationModelImpl implements QuotationModel {
		private final BigDecimal value;
		private final QuotationCharacteristicsModel quotationCharacteristicsModel;
		
		protected QuotationModelImpl(QuotationModel.QuotationModelBuilder builder) {
			this.value = builder.getValue();
			this.quotationCharacteristicsModel = ofNullable(builder.getQuotationCharacteristicsModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("value")
		public BigDecimal getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("quotationCharacteristicsModel")
		public QuotationCharacteristicsModel getQuotationCharacteristicsModel() {
			return quotationCharacteristicsModel;
		}
		
		@Override
		public QuotationModel build() {
			return this;
		}
		
		@Override
		public QuotationModel.QuotationModelBuilder toBuilder() {
			QuotationModel.QuotationModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(QuotationModel.QuotationModelBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getQuotationCharacteristicsModel()).ifPresent(builder::setQuotationCharacteristicsModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			QuotationModel _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(quotationCharacteristicsModel, _that.getQuotationCharacteristicsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (quotationCharacteristicsModel != null ? quotationCharacteristicsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "QuotationModel {" +
				"value=" + this.value + ", " +
				"quotationCharacteristicsModel=" + this.quotationCharacteristicsModel +
			'}';
		}
	}

	/*********************** Builder Implementation of QuotationModel  ***********************/
	class QuotationModelBuilderImpl implements QuotationModel.QuotationModelBuilder {
	
		protected BigDecimal value;
		protected QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder quotationCharacteristicsModel;
	
		public QuotationModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public BigDecimal getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("quotationCharacteristicsModel")
		public QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder getQuotationCharacteristicsModel() {
			return quotationCharacteristicsModel;
		}
		
		@Override
		public QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder getOrCreateQuotationCharacteristicsModel() {
			QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder result;
			if (quotationCharacteristicsModel!=null) {
				result = quotationCharacteristicsModel;
			}
			else {
				result = quotationCharacteristicsModel = QuotationCharacteristicsModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("value")
		public QuotationModel.QuotationModelBuilder setValue(BigDecimal value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("quotationCharacteristicsModel")
		public QuotationModel.QuotationModelBuilder setQuotationCharacteristicsModel(QuotationCharacteristicsModel quotationCharacteristicsModel) {
			this.quotationCharacteristicsModel = quotationCharacteristicsModel==null?null:quotationCharacteristicsModel.toBuilder();
			return this;
		}
		
		@Override
		public QuotationModel build() {
			return new QuotationModel.QuotationModelImpl(this);
		}
		
		@Override
		public QuotationModel.QuotationModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public QuotationModel.QuotationModelBuilder prune() {
			if (quotationCharacteristicsModel!=null && !quotationCharacteristicsModel.prune().hasData()) quotationCharacteristicsModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getQuotationCharacteristicsModel()!=null && getQuotationCharacteristicsModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public QuotationModel.QuotationModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			QuotationModel.QuotationModelBuilder o = (QuotationModel.QuotationModelBuilder) other;
			
			merger.mergeRosetta(getQuotationCharacteristicsModel(), o.getQuotationCharacteristicsModel(), this::setQuotationCharacteristicsModel);
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			QuotationModel _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(quotationCharacteristicsModel, _that.getQuotationCharacteristicsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (quotationCharacteristicsModel != null ? quotationCharacteristicsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "QuotationModelBuilder {" +
				"value=" + this.value + ", " +
				"quotationCharacteristicsModel=" + this.quotationCharacteristicsModel +
			'}';
		}
	}
}
