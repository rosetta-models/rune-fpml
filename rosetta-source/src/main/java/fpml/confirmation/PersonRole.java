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
import fpml.confirmation.PersonRole;
import fpml.confirmation.PersonRole.PersonRoleBuilder;
import fpml.confirmation.PersonRole.PersonRoleBuilderImpl;
import fpml.confirmation.PersonRole.PersonRoleImpl;
import fpml.confirmation.meta.PersonRoleMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type describing a role played by a person in one or more transactions. Examples include roles such as Trader, Broker, MiddleOffice, Legal, etc. This can be extended to provide custom roles.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="PersonRole", builder=PersonRole.PersonRoleBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface PersonRole extends RosettaModelObject {

	PersonRoleMeta metaData = new PersonRoleMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getPersonRoleScheme();

	/*********************** Build Methods  ***********************/
	PersonRole build();
	
	PersonRole.PersonRoleBuilder toBuilder();
	
	static PersonRole.PersonRoleBuilder builder() {
		return new PersonRole.PersonRoleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PersonRole> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PersonRole> getType() {
		return PersonRole.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("personRoleScheme"), String.class, getPersonRoleScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PersonRoleBuilder extends PersonRole, RosettaModelObjectBuilder {
		PersonRole.PersonRoleBuilder setValue(String value);
		PersonRole.PersonRoleBuilder setPersonRoleScheme(String personRoleScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("personRoleScheme"), String.class, getPersonRoleScheme(), this);
		}
		

		PersonRole.PersonRoleBuilder prune();
	}

	/*********************** Immutable Implementation of PersonRole  ***********************/
	class PersonRoleImpl implements PersonRole {
		private final String value;
		private final String personRoleScheme;
		
		protected PersonRoleImpl(PersonRole.PersonRoleBuilder builder) {
			this.value = builder.getValue();
			this.personRoleScheme = builder.getPersonRoleScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("personRoleScheme")
		public String getPersonRoleScheme() {
			return personRoleScheme;
		}
		
		@Override
		public PersonRole build() {
			return this;
		}
		
		@Override
		public PersonRole.PersonRoleBuilder toBuilder() {
			PersonRole.PersonRoleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PersonRole.PersonRoleBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getPersonRoleScheme()).ifPresent(builder::setPersonRoleScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PersonRole _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(personRoleScheme, _that.getPersonRoleScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (personRoleScheme != null ? personRoleScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PersonRole {" +
				"value=" + this.value + ", " +
				"personRoleScheme=" + this.personRoleScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of PersonRole  ***********************/
	class PersonRoleBuilderImpl implements PersonRole.PersonRoleBuilder {
	
		protected String value;
		protected String personRoleScheme;
	
		public PersonRoleBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("personRoleScheme")
		public String getPersonRoleScheme() {
			return personRoleScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public PersonRole.PersonRoleBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("personRoleScheme")
		public PersonRole.PersonRoleBuilder setPersonRoleScheme(String personRoleScheme) {
			this.personRoleScheme = personRoleScheme==null?null:personRoleScheme;
			return this;
		}
		
		@Override
		public PersonRole build() {
			return new PersonRole.PersonRoleImpl(this);
		}
		
		@Override
		public PersonRole.PersonRoleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PersonRole.PersonRoleBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getPersonRoleScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PersonRole.PersonRoleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PersonRole.PersonRoleBuilder o = (PersonRole.PersonRoleBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getPersonRoleScheme(), o.getPersonRoleScheme(), this::setPersonRoleScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PersonRole _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(personRoleScheme, _that.getPersonRoleScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (personRoleScheme != null ? personRoleScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PersonRoleBuilder {" +
				"value=" + this.value + ", " +
				"personRoleScheme=" + this.personRoleScheme +
			'}';
		}
	}
}
