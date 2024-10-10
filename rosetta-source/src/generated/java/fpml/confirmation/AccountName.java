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
import fpml.confirmation.AccountName;
import fpml.confirmation.AccountName.AccountNameBuilder;
import fpml.confirmation.AccountName.AccountNameBuilderImpl;
import fpml.confirmation.AccountName.AccountNameImpl;
import fpml.confirmation.meta.AccountNameMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The data type used for the name of the account.
 * @version ${project.version}
 */
@RosettaDataType(value="AccountName", builder=AccountName.AccountNameBuilderImpl.class, version="${project.version}")
public interface AccountName extends RosettaModelObject {

	AccountNameMeta metaData = new AccountNameMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	/**
	 * The identifier scheme used with this accountName. A unique URI to determine the source of the account name.
	 */
	String getAccountNameScheme();

	/*********************** Build Methods  ***********************/
	AccountName build();
	
	AccountName.AccountNameBuilder toBuilder();
	
	static AccountName.AccountNameBuilder builder() {
		return new AccountName.AccountNameBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AccountName> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AccountName> getType() {
		return AccountName.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("accountNameScheme"), String.class, getAccountNameScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AccountNameBuilder extends AccountName, RosettaModelObjectBuilder {
		AccountName.AccountNameBuilder setValue(String value);
		AccountName.AccountNameBuilder setAccountNameScheme(String accountNameScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("accountNameScheme"), String.class, getAccountNameScheme(), this);
		}
		

		AccountName.AccountNameBuilder prune();
	}

	/*********************** Immutable Implementation of AccountName  ***********************/
	class AccountNameImpl implements AccountName {
		private final String value;
		private final String accountNameScheme;
		
		protected AccountNameImpl(AccountName.AccountNameBuilder builder) {
			this.value = builder.getValue();
			this.accountNameScheme = builder.getAccountNameScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("accountNameScheme")
		public String getAccountNameScheme() {
			return accountNameScheme;
		}
		
		@Override
		public AccountName build() {
			return this;
		}
		
		@Override
		public AccountName.AccountNameBuilder toBuilder() {
			AccountName.AccountNameBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AccountName.AccountNameBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getAccountNameScheme()).ifPresent(builder::setAccountNameScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AccountName _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(accountNameScheme, _that.getAccountNameScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (accountNameScheme != null ? accountNameScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccountName {" +
				"value=" + this.value + ", " +
				"accountNameScheme=" + this.accountNameScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of AccountName  ***********************/
	class AccountNameBuilderImpl implements AccountName.AccountNameBuilder {
	
		protected String value;
		protected String accountNameScheme;
	
		public AccountNameBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("accountNameScheme")
		public String getAccountNameScheme() {
			return accountNameScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public AccountName.AccountNameBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("accountNameScheme")
		public AccountName.AccountNameBuilder setAccountNameScheme(String accountNameScheme) {
			this.accountNameScheme = accountNameScheme==null?null:accountNameScheme;
			return this;
		}
		
		@Override
		public AccountName build() {
			return new AccountName.AccountNameImpl(this);
		}
		
		@Override
		public AccountName.AccountNameBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccountName.AccountNameBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getAccountNameScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccountName.AccountNameBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AccountName.AccountNameBuilder o = (AccountName.AccountNameBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getAccountNameScheme(), o.getAccountNameScheme(), this::setAccountNameScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AccountName _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(accountNameScheme, _that.getAccountNameScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (accountNameScheme != null ? accountNameScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccountNameBuilder {" +
				"value=" + this.value + ", " +
				"accountNameScheme=" + this.accountNameScheme +
			'}';
		}
	}
}
