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
import fpml.confirmation.GenericEquityAttributesModel;
import fpml.confirmation.GenericEquityAttributesModel.GenericEquityAttributesModelBuilder;
import fpml.confirmation.GenericEquityAttributesModel.GenericEquityAttributesModelBuilderImpl;
import fpml.confirmation.GenericEquityAttributesModel.GenericEquityAttributesModelImpl;
import fpml.confirmation.meta.GenericEquityAttributesModelMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="GenericEquityAttributesModel", builder=GenericEquityAttributesModel.GenericEquityAttributesModelBuilderImpl.class, version="${project.version}")
public interface GenericEquityAttributesModel extends RosettaModelObject {

	GenericEquityAttributesModelMeta metaData = new GenericEquityAttributesModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The number of units of underlyer per option comprised in the option transaction.
	 */
	BigDecimal getOptionEntitlement();
	/**
	 * The number of options comprised in the option transaction.
	 */
	BigDecimal getNumberOfOptions();

	/*********************** Build Methods  ***********************/
	GenericEquityAttributesModel build();
	
	GenericEquityAttributesModel.GenericEquityAttributesModelBuilder toBuilder();
	
	static GenericEquityAttributesModel.GenericEquityAttributesModelBuilder builder() {
		return new GenericEquityAttributesModel.GenericEquityAttributesModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends GenericEquityAttributesModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends GenericEquityAttributesModel> getType() {
		return GenericEquityAttributesModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("optionEntitlement"), BigDecimal.class, getOptionEntitlement(), this);
		processor.processBasic(path.newSubPath("numberOfOptions"), BigDecimal.class, getNumberOfOptions(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface GenericEquityAttributesModelBuilder extends GenericEquityAttributesModel, RosettaModelObjectBuilder {
		GenericEquityAttributesModel.GenericEquityAttributesModelBuilder setOptionEntitlement(BigDecimal optionEntitlement);
		GenericEquityAttributesModel.GenericEquityAttributesModelBuilder setNumberOfOptions(BigDecimal numberOfOptions);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("optionEntitlement"), BigDecimal.class, getOptionEntitlement(), this);
			processor.processBasic(path.newSubPath("numberOfOptions"), BigDecimal.class, getNumberOfOptions(), this);
		}
		

		GenericEquityAttributesModel.GenericEquityAttributesModelBuilder prune();
	}

	/*********************** Immutable Implementation of GenericEquityAttributesModel  ***********************/
	class GenericEquityAttributesModelImpl implements GenericEquityAttributesModel {
		private final BigDecimal optionEntitlement;
		private final BigDecimal numberOfOptions;
		
		protected GenericEquityAttributesModelImpl(GenericEquityAttributesModel.GenericEquityAttributesModelBuilder builder) {
			this.optionEntitlement = builder.getOptionEntitlement();
			this.numberOfOptions = builder.getNumberOfOptions();
		}
		
		@Override
		@RosettaAttribute("optionEntitlement")
		public BigDecimal getOptionEntitlement() {
			return optionEntitlement;
		}
		
		@Override
		@RosettaAttribute("numberOfOptions")
		public BigDecimal getNumberOfOptions() {
			return numberOfOptions;
		}
		
		@Override
		public GenericEquityAttributesModel build() {
			return this;
		}
		
		@Override
		public GenericEquityAttributesModel.GenericEquityAttributesModelBuilder toBuilder() {
			GenericEquityAttributesModel.GenericEquityAttributesModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GenericEquityAttributesModel.GenericEquityAttributesModelBuilder builder) {
			ofNullable(getOptionEntitlement()).ifPresent(builder::setOptionEntitlement);
			ofNullable(getNumberOfOptions()).ifPresent(builder::setNumberOfOptions);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GenericEquityAttributesModel _that = getType().cast(o);
		
			if (!Objects.equals(optionEntitlement, _that.getOptionEntitlement())) return false;
			if (!Objects.equals(numberOfOptions, _that.getNumberOfOptions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (optionEntitlement != null ? optionEntitlement.hashCode() : 0);
			_result = 31 * _result + (numberOfOptions != null ? numberOfOptions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericEquityAttributesModel {" +
				"optionEntitlement=" + this.optionEntitlement + ", " +
				"numberOfOptions=" + this.numberOfOptions +
			'}';
		}
	}

	/*********************** Builder Implementation of GenericEquityAttributesModel  ***********************/
	class GenericEquityAttributesModelBuilderImpl implements GenericEquityAttributesModel.GenericEquityAttributesModelBuilder {
	
		protected BigDecimal optionEntitlement;
		protected BigDecimal numberOfOptions;
	
		public GenericEquityAttributesModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("optionEntitlement")
		public BigDecimal getOptionEntitlement() {
			return optionEntitlement;
		}
		
		@Override
		@RosettaAttribute("numberOfOptions")
		public BigDecimal getNumberOfOptions() {
			return numberOfOptions;
		}
		
		@Override
		@RosettaAttribute("optionEntitlement")
		public GenericEquityAttributesModel.GenericEquityAttributesModelBuilder setOptionEntitlement(BigDecimal optionEntitlement) {
			this.optionEntitlement = optionEntitlement==null?null:optionEntitlement;
			return this;
		}
		@Override
		@RosettaAttribute("numberOfOptions")
		public GenericEquityAttributesModel.GenericEquityAttributesModelBuilder setNumberOfOptions(BigDecimal numberOfOptions) {
			this.numberOfOptions = numberOfOptions==null?null:numberOfOptions;
			return this;
		}
		
		@Override
		public GenericEquityAttributesModel build() {
			return new GenericEquityAttributesModel.GenericEquityAttributesModelImpl(this);
		}
		
		@Override
		public GenericEquityAttributesModel.GenericEquityAttributesModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericEquityAttributesModel.GenericEquityAttributesModelBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getOptionEntitlement()!=null) return true;
			if (getNumberOfOptions()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericEquityAttributesModel.GenericEquityAttributesModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			GenericEquityAttributesModel.GenericEquityAttributesModelBuilder o = (GenericEquityAttributesModel.GenericEquityAttributesModelBuilder) other;
			
			
			merger.mergeBasic(getOptionEntitlement(), o.getOptionEntitlement(), this::setOptionEntitlement);
			merger.mergeBasic(getNumberOfOptions(), o.getNumberOfOptions(), this::setNumberOfOptions);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GenericEquityAttributesModel _that = getType().cast(o);
		
			if (!Objects.equals(optionEntitlement, _that.getOptionEntitlement())) return false;
			if (!Objects.equals(numberOfOptions, _that.getNumberOfOptions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (optionEntitlement != null ? optionEntitlement.hashCode() : 0);
			_result = 31 * _result + (numberOfOptions != null ? numberOfOptions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericEquityAttributesModelBuilder {" +
				"optionEntitlement=" + this.optionEntitlement + ", " +
				"numberOfOptions=" + this.numberOfOptions +
			'}';
		}
	}
}
