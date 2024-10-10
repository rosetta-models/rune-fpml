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
import fpml.confirmation.AccountType;
import fpml.confirmation.AccountType.AccountTypeBuilder;
import fpml.confirmation.AccountType.AccountTypeBuilderImpl;
import fpml.confirmation.AccountType.AccountTypeImpl;
import fpml.confirmation.meta.AccountTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The data type used for account type.
 * @version ${project.version}
 */
@RosettaDataType(value="AccountType", builder=AccountType.AccountTypeBuilderImpl.class, version="${project.version}")
public interface AccountType extends RosettaModelObject {

	AccountTypeMeta metaData = new AccountTypeMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	/**
	 * The identifier scheme used with this accountType. A unique URI to determine the the type of account.
	 */
	String getAccountTypeScheme();

	/*********************** Build Methods  ***********************/
	AccountType build();
	
	AccountType.AccountTypeBuilder toBuilder();
	
	static AccountType.AccountTypeBuilder builder() {
		return new AccountType.AccountTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AccountType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AccountType> getType() {
		return AccountType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("accountTypeScheme"), String.class, getAccountTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AccountTypeBuilder extends AccountType, RosettaModelObjectBuilder {
		AccountType.AccountTypeBuilder setValue(String value);
		AccountType.AccountTypeBuilder setAccountTypeScheme(String accountTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("accountTypeScheme"), String.class, getAccountTypeScheme(), this);
		}
		

		AccountType.AccountTypeBuilder prune();
	}

	/*********************** Immutable Implementation of AccountType  ***********************/
	class AccountTypeImpl implements AccountType {
		private final String value;
		private final String accountTypeScheme;
		
		protected AccountTypeImpl(AccountType.AccountTypeBuilder builder) {
			this.value = builder.getValue();
			this.accountTypeScheme = builder.getAccountTypeScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("accountTypeScheme")
		public String getAccountTypeScheme() {
			return accountTypeScheme;
		}
		
		@Override
		public AccountType build() {
			return this;
		}
		
		@Override
		public AccountType.AccountTypeBuilder toBuilder() {
			AccountType.AccountTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AccountType.AccountTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getAccountTypeScheme()).ifPresent(builder::setAccountTypeScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AccountType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(accountTypeScheme, _that.getAccountTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (accountTypeScheme != null ? accountTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccountType {" +
				"value=" + this.value + ", " +
				"accountTypeScheme=" + this.accountTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of AccountType  ***********************/
	class AccountTypeBuilderImpl implements AccountType.AccountTypeBuilder {
	
		protected String value;
		protected String accountTypeScheme;
	
		public AccountTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("accountTypeScheme")
		public String getAccountTypeScheme() {
			return accountTypeScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public AccountType.AccountTypeBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("accountTypeScheme")
		public AccountType.AccountTypeBuilder setAccountTypeScheme(String accountTypeScheme) {
			this.accountTypeScheme = accountTypeScheme==null?null:accountTypeScheme;
			return this;
		}
		
		@Override
		public AccountType build() {
			return new AccountType.AccountTypeImpl(this);
		}
		
		@Override
		public AccountType.AccountTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccountType.AccountTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getAccountTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccountType.AccountTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AccountType.AccountTypeBuilder o = (AccountType.AccountTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getAccountTypeScheme(), o.getAccountTypeScheme(), this::setAccountTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AccountType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(accountTypeScheme, _that.getAccountTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (accountTypeScheme != null ? accountTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccountTypeBuilder {" +
				"value=" + this.value + ", " +
				"accountTypeScheme=" + this.accountTypeScheme +
			'}';
		}
	}
}
