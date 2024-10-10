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
import fpml.confirmation.WithdrawalReason;
import fpml.confirmation.WithdrawalReason.WithdrawalReasonBuilder;
import fpml.confirmation.WithdrawalReason.WithdrawalReasonBuilderImpl;
import fpml.confirmation.WithdrawalReason.WithdrawalReasonImpl;
import fpml.confirmation.meta.WithdrawalReasonMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type that describes why a trade was withdrawn.
 * @version ${project.version}
 */
@RosettaDataType(value="WithdrawalReason", builder=WithdrawalReason.WithdrawalReasonBuilderImpl.class, version="${project.version}")
public interface WithdrawalReason extends RosettaModelObject {

	WithdrawalReasonMeta metaData = new WithdrawalReasonMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getWithdrawalReasonScheme();

	/*********************** Build Methods  ***********************/
	WithdrawalReason build();
	
	WithdrawalReason.WithdrawalReasonBuilder toBuilder();
	
	static WithdrawalReason.WithdrawalReasonBuilder builder() {
		return new WithdrawalReason.WithdrawalReasonBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends WithdrawalReason> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends WithdrawalReason> getType() {
		return WithdrawalReason.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("withdrawalReasonScheme"), String.class, getWithdrawalReasonScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface WithdrawalReasonBuilder extends WithdrawalReason, RosettaModelObjectBuilder {
		WithdrawalReason.WithdrawalReasonBuilder setValue(String value);
		WithdrawalReason.WithdrawalReasonBuilder setWithdrawalReasonScheme(String withdrawalReasonScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("withdrawalReasonScheme"), String.class, getWithdrawalReasonScheme(), this);
		}
		

		WithdrawalReason.WithdrawalReasonBuilder prune();
	}

	/*********************** Immutable Implementation of WithdrawalReason  ***********************/
	class WithdrawalReasonImpl implements WithdrawalReason {
		private final String value;
		private final String withdrawalReasonScheme;
		
		protected WithdrawalReasonImpl(WithdrawalReason.WithdrawalReasonBuilder builder) {
			this.value = builder.getValue();
			this.withdrawalReasonScheme = builder.getWithdrawalReasonScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("withdrawalReasonScheme")
		public String getWithdrawalReasonScheme() {
			return withdrawalReasonScheme;
		}
		
		@Override
		public WithdrawalReason build() {
			return this;
		}
		
		@Override
		public WithdrawalReason.WithdrawalReasonBuilder toBuilder() {
			WithdrawalReason.WithdrawalReasonBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(WithdrawalReason.WithdrawalReasonBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getWithdrawalReasonScheme()).ifPresent(builder::setWithdrawalReasonScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			WithdrawalReason _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(withdrawalReasonScheme, _that.getWithdrawalReasonScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (withdrawalReasonScheme != null ? withdrawalReasonScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "WithdrawalReason {" +
				"value=" + this.value + ", " +
				"withdrawalReasonScheme=" + this.withdrawalReasonScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of WithdrawalReason  ***********************/
	class WithdrawalReasonBuilderImpl implements WithdrawalReason.WithdrawalReasonBuilder {
	
		protected String value;
		protected String withdrawalReasonScheme;
	
		public WithdrawalReasonBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("withdrawalReasonScheme")
		public String getWithdrawalReasonScheme() {
			return withdrawalReasonScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public WithdrawalReason.WithdrawalReasonBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("withdrawalReasonScheme")
		public WithdrawalReason.WithdrawalReasonBuilder setWithdrawalReasonScheme(String withdrawalReasonScheme) {
			this.withdrawalReasonScheme = withdrawalReasonScheme==null?null:withdrawalReasonScheme;
			return this;
		}
		
		@Override
		public WithdrawalReason build() {
			return new WithdrawalReason.WithdrawalReasonImpl(this);
		}
		
		@Override
		public WithdrawalReason.WithdrawalReasonBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public WithdrawalReason.WithdrawalReasonBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getWithdrawalReasonScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public WithdrawalReason.WithdrawalReasonBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			WithdrawalReason.WithdrawalReasonBuilder o = (WithdrawalReason.WithdrawalReasonBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getWithdrawalReasonScheme(), o.getWithdrawalReasonScheme(), this::setWithdrawalReasonScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			WithdrawalReason _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(withdrawalReasonScheme, _that.getWithdrawalReasonScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (withdrawalReasonScheme != null ? withdrawalReasonScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "WithdrawalReasonBuilder {" +
				"value=" + this.value + ", " +
				"withdrawalReasonScheme=" + this.withdrawalReasonScheme +
			'}';
		}
	}
}
