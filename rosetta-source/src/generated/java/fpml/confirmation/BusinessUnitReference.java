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
import fpml.confirmation.BusinessUnitReference;
import fpml.confirmation.BusinessUnitReference.BusinessUnitReferenceBuilder;
import fpml.confirmation.BusinessUnitReference.BusinessUnitReferenceBuilderImpl;
import fpml.confirmation.BusinessUnitReference.BusinessUnitReferenceImpl;
import fpml.confirmation.Reference;
import fpml.confirmation.Reference.ReferenceBuilder;
import fpml.confirmation.Reference.ReferenceBuilderImpl;
import fpml.confirmation.Reference.ReferenceImpl;
import fpml.confirmation.meta.BusinessUnitReferenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Reference to an organizational unit.
 * @version ${project.version}
 */
@RosettaDataType(value="BusinessUnitReference", builder=BusinessUnitReference.BusinessUnitReferenceBuilderImpl.class, version="${project.version}")
public interface BusinessUnitReference extends Reference {

	BusinessUnitReferenceMeta metaData = new BusinessUnitReferenceMeta();

	/*********************** Getter Methods  ***********************/
	String getHref();

	/*********************** Build Methods  ***********************/
	BusinessUnitReference build();
	
	BusinessUnitReference.BusinessUnitReferenceBuilder toBuilder();
	
	static BusinessUnitReference.BusinessUnitReferenceBuilder builder() {
		return new BusinessUnitReference.BusinessUnitReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BusinessUnitReference> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends BusinessUnitReference> getType() {
		return BusinessUnitReference.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface BusinessUnitReferenceBuilder extends BusinessUnitReference, Reference.ReferenceBuilder {
		BusinessUnitReference.BusinessUnitReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		BusinessUnitReference.BusinessUnitReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of BusinessUnitReference  ***********************/
	class BusinessUnitReferenceImpl extends Reference.ReferenceImpl implements BusinessUnitReference {
		private final String href;
		
		protected BusinessUnitReferenceImpl(BusinessUnitReference.BusinessUnitReferenceBuilder builder) {
			super(builder);
			this.href = builder.getHref();
		}
		
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		public BusinessUnitReference build() {
			return this;
		}
		
		@Override
		public BusinessUnitReference.BusinessUnitReferenceBuilder toBuilder() {
			BusinessUnitReference.BusinessUnitReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BusinessUnitReference.BusinessUnitReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			BusinessUnitReference _that = getType().cast(o);
		
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
			return "BusinessUnitReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of BusinessUnitReference  ***********************/
	class BusinessUnitReferenceBuilderImpl extends Reference.ReferenceBuilderImpl  implements BusinessUnitReference.BusinessUnitReferenceBuilder {
	
		protected String href;
	
		public BusinessUnitReferenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		@RosettaAttribute("href")
		public BusinessUnitReference.BusinessUnitReferenceBuilder setHref(String href) {
			this.href = href==null?null:href;
			return this;
		}
		
		@Override
		public BusinessUnitReference build() {
			return new BusinessUnitReference.BusinessUnitReferenceImpl(this);
		}
		
		@Override
		public BusinessUnitReference.BusinessUnitReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BusinessUnitReference.BusinessUnitReferenceBuilder prune() {
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
		public BusinessUnitReference.BusinessUnitReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			BusinessUnitReference.BusinessUnitReferenceBuilder o = (BusinessUnitReference.BusinessUnitReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			BusinessUnitReference _that = getType().cast(o);
		
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
			return "BusinessUnitReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
