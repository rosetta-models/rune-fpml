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
import fpml.confirmation.FloatingRateIndexLoan;
import fpml.confirmation.FloatingRateIndexLoan.FloatingRateIndexLoanBuilder;
import fpml.confirmation.FloatingRateIndexLoan.FloatingRateIndexLoanBuilderImpl;
import fpml.confirmation.FloatingRateIndexLoan.FloatingRateIndexLoanImpl;
import fpml.confirmation.meta.FloatingRateIndexLoanMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A subset of the ISDA Floating Rate Option scheme, i.e. the floating rate index. These indexes are the ones used by the syndicated loan market.
 * @version ${project.version}
 */
@RosettaDataType(value="FloatingRateIndexLoan", builder=FloatingRateIndexLoan.FloatingRateIndexLoanBuilderImpl.class, version="${project.version}")
public interface FloatingRateIndexLoan extends RosettaModelObject {

	FloatingRateIndexLoanMeta metaData = new FloatingRateIndexLoanMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getFloatingRateIndexScheme();

	/*********************** Build Methods  ***********************/
	FloatingRateIndexLoan build();
	
	FloatingRateIndexLoan.FloatingRateIndexLoanBuilder toBuilder();
	
	static FloatingRateIndexLoan.FloatingRateIndexLoanBuilder builder() {
		return new FloatingRateIndexLoan.FloatingRateIndexLoanBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FloatingRateIndexLoan> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FloatingRateIndexLoan> getType() {
		return FloatingRateIndexLoan.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("floatingRateIndexScheme"), String.class, getFloatingRateIndexScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FloatingRateIndexLoanBuilder extends FloatingRateIndexLoan, RosettaModelObjectBuilder {
		FloatingRateIndexLoan.FloatingRateIndexLoanBuilder setValue(String value);
		FloatingRateIndexLoan.FloatingRateIndexLoanBuilder setFloatingRateIndexScheme(String floatingRateIndexScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("floatingRateIndexScheme"), String.class, getFloatingRateIndexScheme(), this);
		}
		

		FloatingRateIndexLoan.FloatingRateIndexLoanBuilder prune();
	}

	/*********************** Immutable Implementation of FloatingRateIndexLoan  ***********************/
	class FloatingRateIndexLoanImpl implements FloatingRateIndexLoan {
		private final String value;
		private final String floatingRateIndexScheme;
		
		protected FloatingRateIndexLoanImpl(FloatingRateIndexLoan.FloatingRateIndexLoanBuilder builder) {
			this.value = builder.getValue();
			this.floatingRateIndexScheme = builder.getFloatingRateIndexScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("floatingRateIndexScheme")
		public String getFloatingRateIndexScheme() {
			return floatingRateIndexScheme;
		}
		
		@Override
		public FloatingRateIndexLoan build() {
			return this;
		}
		
		@Override
		public FloatingRateIndexLoan.FloatingRateIndexLoanBuilder toBuilder() {
			FloatingRateIndexLoan.FloatingRateIndexLoanBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FloatingRateIndexLoan.FloatingRateIndexLoanBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getFloatingRateIndexScheme()).ifPresent(builder::setFloatingRateIndexScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FloatingRateIndexLoan _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(floatingRateIndexScheme, _that.getFloatingRateIndexScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (floatingRateIndexScheme != null ? floatingRateIndexScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateIndexLoan {" +
				"value=" + this.value + ", " +
				"floatingRateIndexScheme=" + this.floatingRateIndexScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of FloatingRateIndexLoan  ***********************/
	class FloatingRateIndexLoanBuilderImpl implements FloatingRateIndexLoan.FloatingRateIndexLoanBuilder {
	
		protected String value;
		protected String floatingRateIndexScheme;
	
		public FloatingRateIndexLoanBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("floatingRateIndexScheme")
		public String getFloatingRateIndexScheme() {
			return floatingRateIndexScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public FloatingRateIndexLoan.FloatingRateIndexLoanBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("floatingRateIndexScheme")
		public FloatingRateIndexLoan.FloatingRateIndexLoanBuilder setFloatingRateIndexScheme(String floatingRateIndexScheme) {
			this.floatingRateIndexScheme = floatingRateIndexScheme==null?null:floatingRateIndexScheme;
			return this;
		}
		
		@Override
		public FloatingRateIndexLoan build() {
			return new FloatingRateIndexLoan.FloatingRateIndexLoanImpl(this);
		}
		
		@Override
		public FloatingRateIndexLoan.FloatingRateIndexLoanBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateIndexLoan.FloatingRateIndexLoanBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getFloatingRateIndexScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateIndexLoan.FloatingRateIndexLoanBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FloatingRateIndexLoan.FloatingRateIndexLoanBuilder o = (FloatingRateIndexLoan.FloatingRateIndexLoanBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getFloatingRateIndexScheme(), o.getFloatingRateIndexScheme(), this::setFloatingRateIndexScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FloatingRateIndexLoan _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(floatingRateIndexScheme, _that.getFloatingRateIndexScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (floatingRateIndexScheme != null ? floatingRateIndexScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateIndexLoanBuilder {" +
				"value=" + this.value + ", " +
				"floatingRateIndexScheme=" + this.floatingRateIndexScheme +
			'}';
		}
	}
}
