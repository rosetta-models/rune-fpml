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
import fpml.confirmation.PersonReference;
import fpml.confirmation.PersonRole;
import fpml.confirmation.RelatedPerson;
import fpml.confirmation.RelatedPerson.RelatedPersonBuilder;
import fpml.confirmation.RelatedPerson.RelatedPersonBuilderImpl;
import fpml.confirmation.RelatedPerson.RelatedPersonImpl;
import fpml.confirmation.meta.RelatedPersonMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="RelatedPerson", builder=RelatedPerson.RelatedPersonBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface RelatedPerson extends RosettaModelObject {

	RelatedPersonMeta metaData = new RelatedPersonMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The individual person that is related to this.
	 */
	PersonReference getPersonReference();
	/**
	 * The category of the relationship. The related individual performs the role specified in this field for the base party. For example, if the role is &quot;Trader&quot;, the related person acts acts or acted as the base party&#39;s trader.
	 */
	PersonRole getRole();

	/*********************** Build Methods  ***********************/
	RelatedPerson build();
	
	RelatedPerson.RelatedPersonBuilder toBuilder();
	
	static RelatedPerson.RelatedPersonBuilder builder() {
		return new RelatedPerson.RelatedPersonBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RelatedPerson> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends RelatedPerson> getType() {
		return RelatedPerson.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("personReference"), processor, PersonReference.class, getPersonReference());
		processRosetta(path.newSubPath("role"), processor, PersonRole.class, getRole());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RelatedPersonBuilder extends RelatedPerson, RosettaModelObjectBuilder {
		PersonReference.PersonReferenceBuilder getOrCreatePersonReference();
		PersonReference.PersonReferenceBuilder getPersonReference();
		PersonRole.PersonRoleBuilder getOrCreateRole();
		PersonRole.PersonRoleBuilder getRole();
		RelatedPerson.RelatedPersonBuilder setPersonReference(PersonReference personReference);
		RelatedPerson.RelatedPersonBuilder setRole(PersonRole role);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("personReference"), processor, PersonReference.PersonReferenceBuilder.class, getPersonReference());
			processRosetta(path.newSubPath("role"), processor, PersonRole.PersonRoleBuilder.class, getRole());
		}
		

		RelatedPerson.RelatedPersonBuilder prune();
	}

	/*********************** Immutable Implementation of RelatedPerson  ***********************/
	class RelatedPersonImpl implements RelatedPerson {
		private final PersonReference personReference;
		private final PersonRole role;
		
		protected RelatedPersonImpl(RelatedPerson.RelatedPersonBuilder builder) {
			this.personReference = ofNullable(builder.getPersonReference()).map(f->f.build()).orElse(null);
			this.role = ofNullable(builder.getRole()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("personReference")
		public PersonReference getPersonReference() {
			return personReference;
		}
		
		@Override
		@RosettaAttribute("role")
		public PersonRole getRole() {
			return role;
		}
		
		@Override
		public RelatedPerson build() {
			return this;
		}
		
		@Override
		public RelatedPerson.RelatedPersonBuilder toBuilder() {
			RelatedPerson.RelatedPersonBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RelatedPerson.RelatedPersonBuilder builder) {
			ofNullable(getPersonReference()).ifPresent(builder::setPersonReference);
			ofNullable(getRole()).ifPresent(builder::setRole);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RelatedPerson _that = getType().cast(o);
		
			if (!Objects.equals(personReference, _that.getPersonReference())) return false;
			if (!Objects.equals(role, _that.getRole())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (personReference != null ? personReference.hashCode() : 0);
			_result = 31 * _result + (role != null ? role.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RelatedPerson {" +
				"personReference=" + this.personReference + ", " +
				"role=" + this.role +
			'}';
		}
	}

	/*********************** Builder Implementation of RelatedPerson  ***********************/
	class RelatedPersonBuilderImpl implements RelatedPerson.RelatedPersonBuilder {
	
		protected PersonReference.PersonReferenceBuilder personReference;
		protected PersonRole.PersonRoleBuilder role;
	
		public RelatedPersonBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("personReference")
		public PersonReference.PersonReferenceBuilder getPersonReference() {
			return personReference;
		}
		
		@Override
		public PersonReference.PersonReferenceBuilder getOrCreatePersonReference() {
			PersonReference.PersonReferenceBuilder result;
			if (personReference!=null) {
				result = personReference;
			}
			else {
				result = personReference = PersonReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("role")
		public PersonRole.PersonRoleBuilder getRole() {
			return role;
		}
		
		@Override
		public PersonRole.PersonRoleBuilder getOrCreateRole() {
			PersonRole.PersonRoleBuilder result;
			if (role!=null) {
				result = role;
			}
			else {
				result = role = PersonRole.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("personReference")
		public RelatedPerson.RelatedPersonBuilder setPersonReference(PersonReference personReference) {
			this.personReference = personReference==null?null:personReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("role")
		public RelatedPerson.RelatedPersonBuilder setRole(PersonRole role) {
			this.role = role==null?null:role.toBuilder();
			return this;
		}
		
		@Override
		public RelatedPerson build() {
			return new RelatedPerson.RelatedPersonImpl(this);
		}
		
		@Override
		public RelatedPerson.RelatedPersonBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RelatedPerson.RelatedPersonBuilder prune() {
			if (personReference!=null && !personReference.prune().hasData()) personReference = null;
			if (role!=null && !role.prune().hasData()) role = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPersonReference()!=null && getPersonReference().hasData()) return true;
			if (getRole()!=null && getRole().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RelatedPerson.RelatedPersonBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RelatedPerson.RelatedPersonBuilder o = (RelatedPerson.RelatedPersonBuilder) other;
			
			merger.mergeRosetta(getPersonReference(), o.getPersonReference(), this::setPersonReference);
			merger.mergeRosetta(getRole(), o.getRole(), this::setRole);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RelatedPerson _that = getType().cast(o);
		
			if (!Objects.equals(personReference, _that.getPersonReference())) return false;
			if (!Objects.equals(role, _that.getRole())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (personReference != null ? personReference.hashCode() : 0);
			_result = 31 * _result + (role != null ? role.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RelatedPersonBuilder {" +
				"personReference=" + this.personReference + ", " +
				"role=" + this.role +
			'}';
		}
	}
}
