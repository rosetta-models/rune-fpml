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
import fpml.confirmation.LegalEntityReference;
import fpml.confirmation.LegalEntityReference.LegalEntityReferenceBuilder;
import fpml.confirmation.LegalEntityReference.LegalEntityReferenceBuilderImpl;
import fpml.confirmation.LegalEntityReference.LegalEntityReferenceImpl;
import fpml.confirmation.Reference;
import fpml.confirmation.Reference.ReferenceBuilder;
import fpml.confirmation.Reference.ReferenceBuilderImpl;
import fpml.confirmation.Reference.ReferenceImpl;
import fpml.confirmation.meta.LegalEntityReferenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * References a credit entity defined elsewhere in the document.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="LegalEntityReference", builder=LegalEntityReference.LegalEntityReferenceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface LegalEntityReference extends Reference {

	LegalEntityReferenceMeta metaData = new LegalEntityReferenceMeta();

	/*********************** Getter Methods  ***********************/
	String getHref();

	/*********************** Build Methods  ***********************/
	LegalEntityReference build();
	
	LegalEntityReference.LegalEntityReferenceBuilder toBuilder();
	
	static LegalEntityReference.LegalEntityReferenceBuilder builder() {
		return new LegalEntityReference.LegalEntityReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LegalEntityReference> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LegalEntityReference> getType() {
		return LegalEntityReference.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LegalEntityReferenceBuilder extends LegalEntityReference, Reference.ReferenceBuilder {
		LegalEntityReference.LegalEntityReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		LegalEntityReference.LegalEntityReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of LegalEntityReference  ***********************/
	class LegalEntityReferenceImpl extends Reference.ReferenceImpl implements LegalEntityReference {
		private final String href;
		
		protected LegalEntityReferenceImpl(LegalEntityReference.LegalEntityReferenceBuilder builder) {
			super(builder);
			this.href = builder.getHref();
		}
		
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		public LegalEntityReference build() {
			return this;
		}
		
		@Override
		public LegalEntityReference.LegalEntityReferenceBuilder toBuilder() {
			LegalEntityReference.LegalEntityReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LegalEntityReference.LegalEntityReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LegalEntityReference _that = getType().cast(o);
		
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
			return "LegalEntityReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LegalEntityReference  ***********************/
	class LegalEntityReferenceBuilderImpl extends Reference.ReferenceBuilderImpl  implements LegalEntityReference.LegalEntityReferenceBuilder {
	
		protected String href;
	
		public LegalEntityReferenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		@RosettaAttribute("href")
		public LegalEntityReference.LegalEntityReferenceBuilder setHref(String href) {
			this.href = href==null?null:href;
			return this;
		}
		
		@Override
		public LegalEntityReference build() {
			return new LegalEntityReference.LegalEntityReferenceImpl(this);
		}
		
		@Override
		public LegalEntityReference.LegalEntityReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegalEntityReference.LegalEntityReferenceBuilder prune() {
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
		public LegalEntityReference.LegalEntityReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LegalEntityReference.LegalEntityReferenceBuilder o = (LegalEntityReference.LegalEntityReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LegalEntityReference _that = getType().cast(o);
		
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
			return "LegalEntityReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
