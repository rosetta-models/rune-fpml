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
import fpml.confirmation.PersonReference.PersonReferenceBuilder;
import fpml.confirmation.PersonReference.PersonReferenceBuilderImpl;
import fpml.confirmation.PersonReference.PersonReferenceImpl;
import fpml.confirmation.Reference;
import fpml.confirmation.Reference.ReferenceBuilder;
import fpml.confirmation.Reference.ReferenceBuilderImpl;
import fpml.confirmation.Reference.ReferenceImpl;
import fpml.confirmation.meta.PersonReferenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Reference to an individual.
 * @version ${project.version}
 */
@RosettaDataType(value="PersonReference", builder=PersonReference.PersonReferenceBuilderImpl.class, version="${project.version}")
public interface PersonReference extends Reference {

	PersonReferenceMeta metaData = new PersonReferenceMeta();

	/*********************** Getter Methods  ***********************/
	String getHref();

	/*********************** Build Methods  ***********************/
	PersonReference build();
	
	PersonReference.PersonReferenceBuilder toBuilder();
	
	static PersonReference.PersonReferenceBuilder builder() {
		return new PersonReference.PersonReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PersonReference> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PersonReference> getType() {
		return PersonReference.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PersonReferenceBuilder extends PersonReference, Reference.ReferenceBuilder {
		PersonReference.PersonReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		PersonReference.PersonReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of PersonReference  ***********************/
	class PersonReferenceImpl extends Reference.ReferenceImpl implements PersonReference {
		private final String href;
		
		protected PersonReferenceImpl(PersonReference.PersonReferenceBuilder builder) {
			super(builder);
			this.href = builder.getHref();
		}
		
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		public PersonReference build() {
			return this;
		}
		
		@Override
		public PersonReference.PersonReferenceBuilder toBuilder() {
			PersonReference.PersonReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PersonReference.PersonReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PersonReference _that = getType().cast(o);
		
			if (!Objects.equals(href, _that.getHref())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (href != null ? href.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PersonReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of PersonReference  ***********************/
	class PersonReferenceBuilderImpl extends Reference.ReferenceBuilderImpl  implements PersonReference.PersonReferenceBuilder {
	
		protected String href;
	
		public PersonReferenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		@RosettaAttribute("href")
		public PersonReference.PersonReferenceBuilder setHref(String href) {
			this.href = href==null?null:href;
			return this;
		}
		
		@Override
		public PersonReference build() {
			return new PersonReference.PersonReferenceImpl(this);
		}
		
		@Override
		public PersonReference.PersonReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PersonReference.PersonReferenceBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getHref()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PersonReference.PersonReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			PersonReference.PersonReferenceBuilder o = (PersonReference.PersonReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PersonReference _that = getType().cast(o);
		
			if (!Objects.equals(href, _that.getHref())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (href != null ? href.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PersonReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
