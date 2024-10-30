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
import fpml.confirmation.ProtectionTermsReference;
import fpml.confirmation.ProtectionTermsReference.ProtectionTermsReferenceBuilder;
import fpml.confirmation.ProtectionTermsReference.ProtectionTermsReferenceBuilderImpl;
import fpml.confirmation.ProtectionTermsReference.ProtectionTermsReferenceImpl;
import fpml.confirmation.Reference;
import fpml.confirmation.Reference.ReferenceBuilder;
import fpml.confirmation.Reference.ReferenceBuilderImpl;
import fpml.confirmation.Reference.ReferenceImpl;
import fpml.confirmation.meta.ProtectionTermsReferenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Reference to protectionTerms component.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="ProtectionTermsReference", builder=ProtectionTermsReference.ProtectionTermsReferenceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface ProtectionTermsReference extends Reference {

	ProtectionTermsReferenceMeta metaData = new ProtectionTermsReferenceMeta();

	/*********************** Getter Methods  ***********************/
	String getHref();

	/*********************** Build Methods  ***********************/
	ProtectionTermsReference build();
	
	ProtectionTermsReference.ProtectionTermsReferenceBuilder toBuilder();
	
	static ProtectionTermsReference.ProtectionTermsReferenceBuilder builder() {
		return new ProtectionTermsReference.ProtectionTermsReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ProtectionTermsReference> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ProtectionTermsReference> getType() {
		return ProtectionTermsReference.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ProtectionTermsReferenceBuilder extends ProtectionTermsReference, Reference.ReferenceBuilder {
		ProtectionTermsReference.ProtectionTermsReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		ProtectionTermsReference.ProtectionTermsReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of ProtectionTermsReference  ***********************/
	class ProtectionTermsReferenceImpl extends Reference.ReferenceImpl implements ProtectionTermsReference {
		private final String href;
		
		protected ProtectionTermsReferenceImpl(ProtectionTermsReference.ProtectionTermsReferenceBuilder builder) {
			super(builder);
			this.href = builder.getHref();
		}
		
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		public ProtectionTermsReference build() {
			return this;
		}
		
		@Override
		public ProtectionTermsReference.ProtectionTermsReferenceBuilder toBuilder() {
			ProtectionTermsReference.ProtectionTermsReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ProtectionTermsReference.ProtectionTermsReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ProtectionTermsReference _that = getType().cast(o);
		
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
			return "ProtectionTermsReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ProtectionTermsReference  ***********************/
	class ProtectionTermsReferenceBuilderImpl extends Reference.ReferenceBuilderImpl  implements ProtectionTermsReference.ProtectionTermsReferenceBuilder {
	
		protected String href;
	
		public ProtectionTermsReferenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		@RosettaAttribute("href")
		public ProtectionTermsReference.ProtectionTermsReferenceBuilder setHref(String href) {
			this.href = href==null?null:href;
			return this;
		}
		
		@Override
		public ProtectionTermsReference build() {
			return new ProtectionTermsReference.ProtectionTermsReferenceImpl(this);
		}
		
		@Override
		public ProtectionTermsReference.ProtectionTermsReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ProtectionTermsReference.ProtectionTermsReferenceBuilder prune() {
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
		public ProtectionTermsReference.ProtectionTermsReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ProtectionTermsReference.ProtectionTermsReferenceBuilder o = (ProtectionTermsReference.ProtectionTermsReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ProtectionTermsReference _that = getType().cast(o);
		
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
			return "ProtectionTermsReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
