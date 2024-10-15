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
import fpml.confirmation.ContractualDefinitions;
import fpml.confirmation.ContractualDefinitions.ContractualDefinitionsBuilder;
import fpml.confirmation.ContractualDefinitions.ContractualDefinitionsBuilderImpl;
import fpml.confirmation.ContractualDefinitions.ContractualDefinitionsImpl;
import fpml.confirmation.meta.ContractualDefinitionsMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The definitions, such as those published by ISDA, that will define the terms of the trade.
 * @version ${project.version}
 */
@RosettaDataType(value="ContractualDefinitions", builder=ContractualDefinitions.ContractualDefinitionsBuilderImpl.class, version="${project.version}")
public interface ContractualDefinitions extends RosettaModelObject {

	ContractualDefinitionsMeta metaData = new ContractualDefinitionsMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getContractualDefinitionsScheme();

	/*********************** Build Methods  ***********************/
	ContractualDefinitions build();
	
	ContractualDefinitions.ContractualDefinitionsBuilder toBuilder();
	
	static ContractualDefinitions.ContractualDefinitionsBuilder builder() {
		return new ContractualDefinitions.ContractualDefinitionsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ContractualDefinitions> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ContractualDefinitions> getType() {
		return ContractualDefinitions.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("contractualDefinitionsScheme"), String.class, getContractualDefinitionsScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ContractualDefinitionsBuilder extends ContractualDefinitions, RosettaModelObjectBuilder {
		ContractualDefinitions.ContractualDefinitionsBuilder setValue(String value);
		ContractualDefinitions.ContractualDefinitionsBuilder setContractualDefinitionsScheme(String contractualDefinitionsScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("contractualDefinitionsScheme"), String.class, getContractualDefinitionsScheme(), this);
		}
		

		ContractualDefinitions.ContractualDefinitionsBuilder prune();
	}

	/*********************** Immutable Implementation of ContractualDefinitions  ***********************/
	class ContractualDefinitionsImpl implements ContractualDefinitions {
		private final String value;
		private final String contractualDefinitionsScheme;
		
		protected ContractualDefinitionsImpl(ContractualDefinitions.ContractualDefinitionsBuilder builder) {
			this.value = builder.getValue();
			this.contractualDefinitionsScheme = builder.getContractualDefinitionsScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("contractualDefinitionsScheme")
		public String getContractualDefinitionsScheme() {
			return contractualDefinitionsScheme;
		}
		
		@Override
		public ContractualDefinitions build() {
			return this;
		}
		
		@Override
		public ContractualDefinitions.ContractualDefinitionsBuilder toBuilder() {
			ContractualDefinitions.ContractualDefinitionsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ContractualDefinitions.ContractualDefinitionsBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getContractualDefinitionsScheme()).ifPresent(builder::setContractualDefinitionsScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ContractualDefinitions _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(contractualDefinitionsScheme, _that.getContractualDefinitionsScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (contractualDefinitionsScheme != null ? contractualDefinitionsScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ContractualDefinitions {" +
				"value=" + this.value + ", " +
				"contractualDefinitionsScheme=" + this.contractualDefinitionsScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of ContractualDefinitions  ***********************/
	class ContractualDefinitionsBuilderImpl implements ContractualDefinitions.ContractualDefinitionsBuilder {
	
		protected String value;
		protected String contractualDefinitionsScheme;
	
		public ContractualDefinitionsBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("contractualDefinitionsScheme")
		public String getContractualDefinitionsScheme() {
			return contractualDefinitionsScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public ContractualDefinitions.ContractualDefinitionsBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("contractualDefinitionsScheme")
		public ContractualDefinitions.ContractualDefinitionsBuilder setContractualDefinitionsScheme(String contractualDefinitionsScheme) {
			this.contractualDefinitionsScheme = contractualDefinitionsScheme==null?null:contractualDefinitionsScheme;
			return this;
		}
		
		@Override
		public ContractualDefinitions build() {
			return new ContractualDefinitions.ContractualDefinitionsImpl(this);
		}
		
		@Override
		public ContractualDefinitions.ContractualDefinitionsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ContractualDefinitions.ContractualDefinitionsBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getContractualDefinitionsScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ContractualDefinitions.ContractualDefinitionsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ContractualDefinitions.ContractualDefinitionsBuilder o = (ContractualDefinitions.ContractualDefinitionsBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getContractualDefinitionsScheme(), o.getContractualDefinitionsScheme(), this::setContractualDefinitionsScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ContractualDefinitions _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(contractualDefinitionsScheme, _that.getContractualDefinitionsScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (contractualDefinitionsScheme != null ? contractualDefinitionsScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ContractualDefinitionsBuilder {" +
				"value=" + this.value + ", " +
				"contractualDefinitionsScheme=" + this.contractualDefinitionsScheme +
			'}';
		}
	}
}
