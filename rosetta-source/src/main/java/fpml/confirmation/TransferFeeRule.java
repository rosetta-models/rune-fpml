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
import fpml.confirmation.TransferFeeRule;
import fpml.confirmation.TransferFeeRule.TransferFeeRuleBuilder;
import fpml.confirmation.TransferFeeRule.TransferFeeRuleBuilderImpl;
import fpml.confirmation.TransferFeeRule.TransferFeeRuleImpl;
import fpml.confirmation.meta.TransferFeeRuleMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A list of rules associated with the way in which transfer fees should be paid.
 * @version ${project.version}
 */
@RosettaDataType(value="TransferFeeRule", builder=TransferFeeRule.TransferFeeRuleBuilderImpl.class, version="${project.version}")
public interface TransferFeeRule extends RosettaModelObject {

	TransferFeeRuleMeta metaData = new TransferFeeRuleMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getTransferFeeRuleScheme();

	/*********************** Build Methods  ***********************/
	TransferFeeRule build();
	
	TransferFeeRule.TransferFeeRuleBuilder toBuilder();
	
	static TransferFeeRule.TransferFeeRuleBuilder builder() {
		return new TransferFeeRule.TransferFeeRuleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TransferFeeRule> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TransferFeeRule> getType() {
		return TransferFeeRule.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("transferFeeRuleScheme"), String.class, getTransferFeeRuleScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TransferFeeRuleBuilder extends TransferFeeRule, RosettaModelObjectBuilder {
		TransferFeeRule.TransferFeeRuleBuilder setValue(String value);
		TransferFeeRule.TransferFeeRuleBuilder setTransferFeeRuleScheme(String transferFeeRuleScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("transferFeeRuleScheme"), String.class, getTransferFeeRuleScheme(), this);
		}
		

		TransferFeeRule.TransferFeeRuleBuilder prune();
	}

	/*********************** Immutable Implementation of TransferFeeRule  ***********************/
	class TransferFeeRuleImpl implements TransferFeeRule {
		private final String value;
		private final String transferFeeRuleScheme;
		
		protected TransferFeeRuleImpl(TransferFeeRule.TransferFeeRuleBuilder builder) {
			this.value = builder.getValue();
			this.transferFeeRuleScheme = builder.getTransferFeeRuleScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("transferFeeRuleScheme")
		public String getTransferFeeRuleScheme() {
			return transferFeeRuleScheme;
		}
		
		@Override
		public TransferFeeRule build() {
			return this;
		}
		
		@Override
		public TransferFeeRule.TransferFeeRuleBuilder toBuilder() {
			TransferFeeRule.TransferFeeRuleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TransferFeeRule.TransferFeeRuleBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getTransferFeeRuleScheme()).ifPresent(builder::setTransferFeeRuleScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TransferFeeRule _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(transferFeeRuleScheme, _that.getTransferFeeRuleScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (transferFeeRuleScheme != null ? transferFeeRuleScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TransferFeeRule {" +
				"value=" + this.value + ", " +
				"transferFeeRuleScheme=" + this.transferFeeRuleScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of TransferFeeRule  ***********************/
	class TransferFeeRuleBuilderImpl implements TransferFeeRule.TransferFeeRuleBuilder {
	
		protected String value;
		protected String transferFeeRuleScheme;
	
		public TransferFeeRuleBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("transferFeeRuleScheme")
		public String getTransferFeeRuleScheme() {
			return transferFeeRuleScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public TransferFeeRule.TransferFeeRuleBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("transferFeeRuleScheme")
		public TransferFeeRule.TransferFeeRuleBuilder setTransferFeeRuleScheme(String transferFeeRuleScheme) {
			this.transferFeeRuleScheme = transferFeeRuleScheme==null?null:transferFeeRuleScheme;
			return this;
		}
		
		@Override
		public TransferFeeRule build() {
			return new TransferFeeRule.TransferFeeRuleImpl(this);
		}
		
		@Override
		public TransferFeeRule.TransferFeeRuleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TransferFeeRule.TransferFeeRuleBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getTransferFeeRuleScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TransferFeeRule.TransferFeeRuleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TransferFeeRule.TransferFeeRuleBuilder o = (TransferFeeRule.TransferFeeRuleBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getTransferFeeRuleScheme(), o.getTransferFeeRuleScheme(), this::setTransferFeeRuleScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TransferFeeRule _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(transferFeeRuleScheme, _that.getTransferFeeRuleScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (transferFeeRuleScheme != null ? transferFeeRuleScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TransferFeeRuleBuilder {" +
				"value=" + this.value + ", " +
				"transferFeeRuleScheme=" + this.transferFeeRuleScheme +
			'}';
		}
	}
}
