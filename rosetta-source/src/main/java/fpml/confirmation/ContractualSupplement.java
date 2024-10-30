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
import fpml.confirmation.ContractualSupplement;
import fpml.confirmation.ContractualSupplement.ContractualSupplementBuilder;
import fpml.confirmation.ContractualSupplement.ContractualSupplementBuilderImpl;
import fpml.confirmation.ContractualSupplement.ContractualSupplementImpl;
import fpml.confirmation.meta.ContractualSupplementMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A contractual supplement (such as those published by ISDA) that will apply to the trade.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="ContractualSupplement", builder=ContractualSupplement.ContractualSupplementBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface ContractualSupplement extends RosettaModelObject {

	ContractualSupplementMeta metaData = new ContractualSupplementMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getContractualSupplementScheme();

	/*********************** Build Methods  ***********************/
	ContractualSupplement build();
	
	ContractualSupplement.ContractualSupplementBuilder toBuilder();
	
	static ContractualSupplement.ContractualSupplementBuilder builder() {
		return new ContractualSupplement.ContractualSupplementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ContractualSupplement> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ContractualSupplement> getType() {
		return ContractualSupplement.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("contractualSupplementScheme"), String.class, getContractualSupplementScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ContractualSupplementBuilder extends ContractualSupplement, RosettaModelObjectBuilder {
		ContractualSupplement.ContractualSupplementBuilder setValue(String value);
		ContractualSupplement.ContractualSupplementBuilder setContractualSupplementScheme(String contractualSupplementScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("contractualSupplementScheme"), String.class, getContractualSupplementScheme(), this);
		}
		

		ContractualSupplement.ContractualSupplementBuilder prune();
	}

	/*********************** Immutable Implementation of ContractualSupplement  ***********************/
	class ContractualSupplementImpl implements ContractualSupplement {
		private final String value;
		private final String contractualSupplementScheme;
		
		protected ContractualSupplementImpl(ContractualSupplement.ContractualSupplementBuilder builder) {
			this.value = builder.getValue();
			this.contractualSupplementScheme = builder.getContractualSupplementScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("contractualSupplementScheme")
		public String getContractualSupplementScheme() {
			return contractualSupplementScheme;
		}
		
		@Override
		public ContractualSupplement build() {
			return this;
		}
		
		@Override
		public ContractualSupplement.ContractualSupplementBuilder toBuilder() {
			ContractualSupplement.ContractualSupplementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ContractualSupplement.ContractualSupplementBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getContractualSupplementScheme()).ifPresent(builder::setContractualSupplementScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ContractualSupplement _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(contractualSupplementScheme, _that.getContractualSupplementScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (contractualSupplementScheme != null ? contractualSupplementScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ContractualSupplement {" +
				"value=" + this.value + ", " +
				"contractualSupplementScheme=" + this.contractualSupplementScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of ContractualSupplement  ***********************/
	class ContractualSupplementBuilderImpl implements ContractualSupplement.ContractualSupplementBuilder {
	
		protected String value;
		protected String contractualSupplementScheme;
	
		public ContractualSupplementBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("contractualSupplementScheme")
		public String getContractualSupplementScheme() {
			return contractualSupplementScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public ContractualSupplement.ContractualSupplementBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("contractualSupplementScheme")
		public ContractualSupplement.ContractualSupplementBuilder setContractualSupplementScheme(String contractualSupplementScheme) {
			this.contractualSupplementScheme = contractualSupplementScheme==null?null:contractualSupplementScheme;
			return this;
		}
		
		@Override
		public ContractualSupplement build() {
			return new ContractualSupplement.ContractualSupplementImpl(this);
		}
		
		@Override
		public ContractualSupplement.ContractualSupplementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ContractualSupplement.ContractualSupplementBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getContractualSupplementScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ContractualSupplement.ContractualSupplementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ContractualSupplement.ContractualSupplementBuilder o = (ContractualSupplement.ContractualSupplementBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getContractualSupplementScheme(), o.getContractualSupplementScheme(), this::setContractualSupplementScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ContractualSupplement _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(contractualSupplementScheme, _that.getContractualSupplementScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (contractualSupplementScheme != null ? contractualSupplementScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ContractualSupplementBuilder {" +
				"value=" + this.value + ", " +
				"contractualSupplementScheme=" + this.contractualSupplementScheme +
			'}';
		}
	}
}
