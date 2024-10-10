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
import fpml.confirmation.LoanTradingPartyRole;
import fpml.confirmation.LoanTradingPartyRole.LoanTradingPartyRoleBuilder;
import fpml.confirmation.LoanTradingPartyRole.LoanTradingPartyRoleBuilderImpl;
import fpml.confirmation.LoanTradingPartyRole.LoanTradingPartyRoleImpl;
import fpml.confirmation.meta.LoanTradingPartyRoleMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type that describes a role played by a party in a trading transaction. Examples include roles such as guarantor, custodian, confirmation service provider, etc. This can be extended to provide custom roles.
 * @version ${project.version}
 */
@RosettaDataType(value="LoanTradingPartyRole", builder=LoanTradingPartyRole.LoanTradingPartyRoleBuilderImpl.class, version="${project.version}")
public interface LoanTradingPartyRole extends RosettaModelObject {

	LoanTradingPartyRoleMeta metaData = new LoanTradingPartyRoleMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getTradingPartyRoleScheme();

	/*********************** Build Methods  ***********************/
	LoanTradingPartyRole build();
	
	LoanTradingPartyRole.LoanTradingPartyRoleBuilder toBuilder();
	
	static LoanTradingPartyRole.LoanTradingPartyRoleBuilder builder() {
		return new LoanTradingPartyRole.LoanTradingPartyRoleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanTradingPartyRole> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanTradingPartyRole> getType() {
		return LoanTradingPartyRole.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("tradingPartyRoleScheme"), String.class, getTradingPartyRoleScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanTradingPartyRoleBuilder extends LoanTradingPartyRole, RosettaModelObjectBuilder {
		LoanTradingPartyRole.LoanTradingPartyRoleBuilder setValue(String value);
		LoanTradingPartyRole.LoanTradingPartyRoleBuilder setTradingPartyRoleScheme(String tradingPartyRoleScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("tradingPartyRoleScheme"), String.class, getTradingPartyRoleScheme(), this);
		}
		

		LoanTradingPartyRole.LoanTradingPartyRoleBuilder prune();
	}

	/*********************** Immutable Implementation of LoanTradingPartyRole  ***********************/
	class LoanTradingPartyRoleImpl implements LoanTradingPartyRole {
		private final String value;
		private final String tradingPartyRoleScheme;
		
		protected LoanTradingPartyRoleImpl(LoanTradingPartyRole.LoanTradingPartyRoleBuilder builder) {
			this.value = builder.getValue();
			this.tradingPartyRoleScheme = builder.getTradingPartyRoleScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("tradingPartyRoleScheme")
		public String getTradingPartyRoleScheme() {
			return tradingPartyRoleScheme;
		}
		
		@Override
		public LoanTradingPartyRole build() {
			return this;
		}
		
		@Override
		public LoanTradingPartyRole.LoanTradingPartyRoleBuilder toBuilder() {
			LoanTradingPartyRole.LoanTradingPartyRoleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanTradingPartyRole.LoanTradingPartyRoleBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getTradingPartyRoleScheme()).ifPresent(builder::setTradingPartyRoleScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanTradingPartyRole _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(tradingPartyRoleScheme, _that.getTradingPartyRoleScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (tradingPartyRoleScheme != null ? tradingPartyRoleScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradingPartyRole {" +
				"value=" + this.value + ", " +
				"tradingPartyRoleScheme=" + this.tradingPartyRoleScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanTradingPartyRole  ***********************/
	class LoanTradingPartyRoleBuilderImpl implements LoanTradingPartyRole.LoanTradingPartyRoleBuilder {
	
		protected String value;
		protected String tradingPartyRoleScheme;
	
		public LoanTradingPartyRoleBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("tradingPartyRoleScheme")
		public String getTradingPartyRoleScheme() {
			return tradingPartyRoleScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public LoanTradingPartyRole.LoanTradingPartyRoleBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("tradingPartyRoleScheme")
		public LoanTradingPartyRole.LoanTradingPartyRoleBuilder setTradingPartyRoleScheme(String tradingPartyRoleScheme) {
			this.tradingPartyRoleScheme = tradingPartyRoleScheme==null?null:tradingPartyRoleScheme;
			return this;
		}
		
		@Override
		public LoanTradingPartyRole build() {
			return new LoanTradingPartyRole.LoanTradingPartyRoleImpl(this);
		}
		
		@Override
		public LoanTradingPartyRole.LoanTradingPartyRoleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradingPartyRole.LoanTradingPartyRoleBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getTradingPartyRoleScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradingPartyRole.LoanTradingPartyRoleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanTradingPartyRole.LoanTradingPartyRoleBuilder o = (LoanTradingPartyRole.LoanTradingPartyRoleBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getTradingPartyRoleScheme(), o.getTradingPartyRoleScheme(), this::setTradingPartyRoleScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanTradingPartyRole _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(tradingPartyRoleScheme, _that.getTradingPartyRoleScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (tradingPartyRoleScheme != null ? tradingPartyRoleScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradingPartyRoleBuilder {" +
				"value=" + this.value + ", " +
				"tradingPartyRoleScheme=" + this.tradingPartyRoleScheme +
			'}';
		}
	}
}
