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
import fpml.confirmation.CashflowType;
import fpml.confirmation.CashflowType.CashflowTypeBuilder;
import fpml.confirmation.CashflowType.CashflowTypeBuilderImpl;
import fpml.confirmation.CashflowType.CashflowTypeImpl;
import fpml.confirmation.meta.CashflowTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A coding scheme used to describe the type or purpose of a cash flow or cash flow component.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CashflowType", builder=CashflowType.CashflowTypeBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CashflowType extends RosettaModelObject {

	CashflowTypeMeta metaData = new CashflowTypeMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getCashflowTypeScheme();

	/*********************** Build Methods  ***********************/
	CashflowType build();
	
	CashflowType.CashflowTypeBuilder toBuilder();
	
	static CashflowType.CashflowTypeBuilder builder() {
		return new CashflowType.CashflowTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CashflowType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CashflowType> getType() {
		return CashflowType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("cashflowTypeScheme"), String.class, getCashflowTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CashflowTypeBuilder extends CashflowType, RosettaModelObjectBuilder {
		CashflowType.CashflowTypeBuilder setValue(String value);
		CashflowType.CashflowTypeBuilder setCashflowTypeScheme(String cashflowTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("cashflowTypeScheme"), String.class, getCashflowTypeScheme(), this);
		}
		

		CashflowType.CashflowTypeBuilder prune();
	}

	/*********************** Immutable Implementation of CashflowType  ***********************/
	class CashflowTypeImpl implements CashflowType {
		private final String value;
		private final String cashflowTypeScheme;
		
		protected CashflowTypeImpl(CashflowType.CashflowTypeBuilder builder) {
			this.value = builder.getValue();
			this.cashflowTypeScheme = builder.getCashflowTypeScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("cashflowTypeScheme")
		public String getCashflowTypeScheme() {
			return cashflowTypeScheme;
		}
		
		@Override
		public CashflowType build() {
			return this;
		}
		
		@Override
		public CashflowType.CashflowTypeBuilder toBuilder() {
			CashflowType.CashflowTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CashflowType.CashflowTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCashflowTypeScheme()).ifPresent(builder::setCashflowTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CashflowType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(cashflowTypeScheme, _that.getCashflowTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (cashflowTypeScheme != null ? cashflowTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CashflowType {" +
				"value=" + this.value + ", " +
				"cashflowTypeScheme=" + this.cashflowTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CashflowType  ***********************/
	class CashflowTypeBuilderImpl implements CashflowType.CashflowTypeBuilder {
	
		protected String value;
		protected String cashflowTypeScheme;
	
		public CashflowTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("cashflowTypeScheme")
		public String getCashflowTypeScheme() {
			return cashflowTypeScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public CashflowType.CashflowTypeBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("cashflowTypeScheme")
		public CashflowType.CashflowTypeBuilder setCashflowTypeScheme(String cashflowTypeScheme) {
			this.cashflowTypeScheme = cashflowTypeScheme==null?null:cashflowTypeScheme;
			return this;
		}
		
		@Override
		public CashflowType build() {
			return new CashflowType.CashflowTypeImpl(this);
		}
		
		@Override
		public CashflowType.CashflowTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CashflowType.CashflowTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCashflowTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CashflowType.CashflowTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CashflowType.CashflowTypeBuilder o = (CashflowType.CashflowTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCashflowTypeScheme(), o.getCashflowTypeScheme(), this::setCashflowTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CashflowType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(cashflowTypeScheme, _that.getCashflowTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (cashflowTypeScheme != null ? cashflowTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CashflowTypeBuilder {" +
				"value=" + this.value + ", " +
				"cashflowTypeScheme=" + this.cashflowTypeScheme +
			'}';
		}
	}
}
