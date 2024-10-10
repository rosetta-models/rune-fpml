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
import fpml.confirmation.BusinessCentersReference;
import fpml.confirmation.BusinessCentersReference.BusinessCentersReferenceBuilder;
import fpml.confirmation.BusinessCentersReference.BusinessCentersReferenceBuilderImpl;
import fpml.confirmation.BusinessCentersReference.BusinessCentersReferenceImpl;
import fpml.confirmation.Reference;
import fpml.confirmation.Reference.ReferenceBuilder;
import fpml.confirmation.Reference.ReferenceBuilderImpl;
import fpml.confirmation.Reference.ReferenceImpl;
import fpml.confirmation.meta.BusinessCentersReferenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A pointer style reference to a set of business day calendar defined elsewhere in the document.
 * @version ${project.version}
 */
@RosettaDataType(value="BusinessCentersReference", builder=BusinessCentersReference.BusinessCentersReferenceBuilderImpl.class, version="${project.version}")
public interface BusinessCentersReference extends Reference {

	BusinessCentersReferenceMeta metaData = new BusinessCentersReferenceMeta();

	/*********************** Getter Methods  ***********************/
	String getHref();

	/*********************** Build Methods  ***********************/
	BusinessCentersReference build();
	
	BusinessCentersReference.BusinessCentersReferenceBuilder toBuilder();
	
	static BusinessCentersReference.BusinessCentersReferenceBuilder builder() {
		return new BusinessCentersReference.BusinessCentersReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BusinessCentersReference> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends BusinessCentersReference> getType() {
		return BusinessCentersReference.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface BusinessCentersReferenceBuilder extends BusinessCentersReference, Reference.ReferenceBuilder {
		BusinessCentersReference.BusinessCentersReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		BusinessCentersReference.BusinessCentersReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of BusinessCentersReference  ***********************/
	class BusinessCentersReferenceImpl extends Reference.ReferenceImpl implements BusinessCentersReference {
		private final String href;
		
		protected BusinessCentersReferenceImpl(BusinessCentersReference.BusinessCentersReferenceBuilder builder) {
			super(builder);
			this.href = builder.getHref();
		}
		
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		public BusinessCentersReference build() {
			return this;
		}
		
		@Override
		public BusinessCentersReference.BusinessCentersReferenceBuilder toBuilder() {
			BusinessCentersReference.BusinessCentersReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BusinessCentersReference.BusinessCentersReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			BusinessCentersReference _that = getType().cast(o);
		
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
			return "BusinessCentersReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of BusinessCentersReference  ***********************/
	class BusinessCentersReferenceBuilderImpl extends Reference.ReferenceBuilderImpl  implements BusinessCentersReference.BusinessCentersReferenceBuilder {
	
		protected String href;
	
		public BusinessCentersReferenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		@RosettaAttribute("href")
		public BusinessCentersReference.BusinessCentersReferenceBuilder setHref(String href) {
			this.href = href==null?null:href;
			return this;
		}
		
		@Override
		public BusinessCentersReference build() {
			return new BusinessCentersReference.BusinessCentersReferenceImpl(this);
		}
		
		@Override
		public BusinessCentersReference.BusinessCentersReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BusinessCentersReference.BusinessCentersReferenceBuilder prune() {
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
		public BusinessCentersReference.BusinessCentersReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			BusinessCentersReference.BusinessCentersReferenceBuilder o = (BusinessCentersReference.BusinessCentersReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			BusinessCentersReference _that = getType().cast(o);
		
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
			return "BusinessCentersReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
