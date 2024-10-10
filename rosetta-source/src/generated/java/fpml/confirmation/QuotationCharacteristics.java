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
import fpml.confirmation.QuotationCharacteristics;
import fpml.confirmation.QuotationCharacteristics.QuotationCharacteristicsBuilder;
import fpml.confirmation.QuotationCharacteristics.QuotationCharacteristicsBuilderImpl;
import fpml.confirmation.QuotationCharacteristics.QuotationCharacteristicsImpl;
import fpml.confirmation.QuotationCharacteristicsModel;
import fpml.confirmation.meta.QuotationCharacteristicsMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type representing a set of characteristics that describe a quotation.
 * @version ${project.version}
 */
@RosettaDataType(value="QuotationCharacteristics", builder=QuotationCharacteristics.QuotationCharacteristicsBuilderImpl.class, version="${project.version}")
public interface QuotationCharacteristics extends RosettaModelObject {

	QuotationCharacteristicsMeta metaData = new QuotationCharacteristicsMeta();

	/*********************** Getter Methods  ***********************/
	QuotationCharacteristicsModel getQuotationCharacteristicsModel();

	/*********************** Build Methods  ***********************/
	QuotationCharacteristics build();
	
	QuotationCharacteristics.QuotationCharacteristicsBuilder toBuilder();
	
	static QuotationCharacteristics.QuotationCharacteristicsBuilder builder() {
		return new QuotationCharacteristics.QuotationCharacteristicsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends QuotationCharacteristics> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends QuotationCharacteristics> getType() {
		return QuotationCharacteristics.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("quotationCharacteristicsModel"), processor, QuotationCharacteristicsModel.class, getQuotationCharacteristicsModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface QuotationCharacteristicsBuilder extends QuotationCharacteristics, RosettaModelObjectBuilder {
		QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder getOrCreateQuotationCharacteristicsModel();
		QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder getQuotationCharacteristicsModel();
		QuotationCharacteristics.QuotationCharacteristicsBuilder setQuotationCharacteristicsModel(QuotationCharacteristicsModel quotationCharacteristicsModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("quotationCharacteristicsModel"), processor, QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder.class, getQuotationCharacteristicsModel());
		}
		

		QuotationCharacteristics.QuotationCharacteristicsBuilder prune();
	}

	/*********************** Immutable Implementation of QuotationCharacteristics  ***********************/
	class QuotationCharacteristicsImpl implements QuotationCharacteristics {
		private final QuotationCharacteristicsModel quotationCharacteristicsModel;
		
		protected QuotationCharacteristicsImpl(QuotationCharacteristics.QuotationCharacteristicsBuilder builder) {
			this.quotationCharacteristicsModel = ofNullable(builder.getQuotationCharacteristicsModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("quotationCharacteristicsModel")
		public QuotationCharacteristicsModel getQuotationCharacteristicsModel() {
			return quotationCharacteristicsModel;
		}
		
		@Override
		public QuotationCharacteristics build() {
			return this;
		}
		
		@Override
		public QuotationCharacteristics.QuotationCharacteristicsBuilder toBuilder() {
			QuotationCharacteristics.QuotationCharacteristicsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(QuotationCharacteristics.QuotationCharacteristicsBuilder builder) {
			ofNullable(getQuotationCharacteristicsModel()).ifPresent(builder::setQuotationCharacteristicsModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			QuotationCharacteristics _that = getType().cast(o);
		
			if (!Objects.equals(quotationCharacteristicsModel, _that.getQuotationCharacteristicsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (quotationCharacteristicsModel != null ? quotationCharacteristicsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "QuotationCharacteristics {" +
				"quotationCharacteristicsModel=" + this.quotationCharacteristicsModel +
			'}';
		}
	}

	/*********************** Builder Implementation of QuotationCharacteristics  ***********************/
	class QuotationCharacteristicsBuilderImpl implements QuotationCharacteristics.QuotationCharacteristicsBuilder {
	
		protected QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder quotationCharacteristicsModel;
	
		public QuotationCharacteristicsBuilderImpl() {
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
		@RosettaAttribute("quotationCharacteristicsModel")
		public QuotationCharacteristics.QuotationCharacteristicsBuilder setQuotationCharacteristicsModel(QuotationCharacteristicsModel quotationCharacteristicsModel) {
			this.quotationCharacteristicsModel = quotationCharacteristicsModel==null?null:quotationCharacteristicsModel.toBuilder();
			return this;
		}
		
		@Override
		public QuotationCharacteristics build() {
			return new QuotationCharacteristics.QuotationCharacteristicsImpl(this);
		}
		
		@Override
		public QuotationCharacteristics.QuotationCharacteristicsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public QuotationCharacteristics.QuotationCharacteristicsBuilder prune() {
			if (quotationCharacteristicsModel!=null && !quotationCharacteristicsModel.prune().hasData()) quotationCharacteristicsModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getQuotationCharacteristicsModel()!=null && getQuotationCharacteristicsModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public QuotationCharacteristics.QuotationCharacteristicsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			QuotationCharacteristics.QuotationCharacteristicsBuilder o = (QuotationCharacteristics.QuotationCharacteristicsBuilder) other;
			
			merger.mergeRosetta(getQuotationCharacteristicsModel(), o.getQuotationCharacteristicsModel(), this::setQuotationCharacteristicsModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			QuotationCharacteristics _that = getType().cast(o);
		
			if (!Objects.equals(quotationCharacteristicsModel, _that.getQuotationCharacteristicsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (quotationCharacteristicsModel != null ? quotationCharacteristicsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "QuotationCharacteristicsBuilder {" +
				"quotationCharacteristicsModel=" + this.quotationCharacteristicsModel +
			'}';
		}
	}
}
