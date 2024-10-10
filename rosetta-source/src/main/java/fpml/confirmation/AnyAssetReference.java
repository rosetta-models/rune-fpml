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
import fpml.confirmation.AnyAssetReference;
import fpml.confirmation.AnyAssetReference.AnyAssetReferenceBuilder;
import fpml.confirmation.AnyAssetReference.AnyAssetReferenceBuilderImpl;
import fpml.confirmation.AnyAssetReference.AnyAssetReferenceImpl;
import fpml.confirmation.Reference;
import fpml.confirmation.Reference.ReferenceBuilder;
import fpml.confirmation.Reference.ReferenceBuilderImpl;
import fpml.confirmation.Reference.ReferenceImpl;
import fpml.confirmation.meta.AnyAssetReferenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A reference to an asset, e.g. a portfolio, trade, or reference instrument..
 * @version ${project.version}
 */
@RosettaDataType(value="AnyAssetReference", builder=AnyAssetReference.AnyAssetReferenceBuilderImpl.class, version="${project.version}")
public interface AnyAssetReference extends Reference {

	AnyAssetReferenceMeta metaData = new AnyAssetReferenceMeta();

	/*********************** Getter Methods  ***********************/
	String getHref();

	/*********************** Build Methods  ***********************/
	AnyAssetReference build();
	
	AnyAssetReference.AnyAssetReferenceBuilder toBuilder();
	
	static AnyAssetReference.AnyAssetReferenceBuilder builder() {
		return new AnyAssetReference.AnyAssetReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AnyAssetReference> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AnyAssetReference> getType() {
		return AnyAssetReference.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AnyAssetReferenceBuilder extends AnyAssetReference, Reference.ReferenceBuilder {
		AnyAssetReference.AnyAssetReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		AnyAssetReference.AnyAssetReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of AnyAssetReference  ***********************/
	class AnyAssetReferenceImpl extends Reference.ReferenceImpl implements AnyAssetReference {
		private final String href;
		
		protected AnyAssetReferenceImpl(AnyAssetReference.AnyAssetReferenceBuilder builder) {
			super(builder);
			this.href = builder.getHref();
		}
		
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		public AnyAssetReference build() {
			return this;
		}
		
		@Override
		public AnyAssetReference.AnyAssetReferenceBuilder toBuilder() {
			AnyAssetReference.AnyAssetReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AnyAssetReference.AnyAssetReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AnyAssetReference _that = getType().cast(o);
		
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
			return "AnyAssetReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AnyAssetReference  ***********************/
	class AnyAssetReferenceBuilderImpl extends Reference.ReferenceBuilderImpl  implements AnyAssetReference.AnyAssetReferenceBuilder {
	
		protected String href;
	
		public AnyAssetReferenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		@RosettaAttribute("href")
		public AnyAssetReference.AnyAssetReferenceBuilder setHref(String href) {
			this.href = href==null?null:href;
			return this;
		}
		
		@Override
		public AnyAssetReference build() {
			return new AnyAssetReference.AnyAssetReferenceImpl(this);
		}
		
		@Override
		public AnyAssetReference.AnyAssetReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnyAssetReference.AnyAssetReferenceBuilder prune() {
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
		public AnyAssetReference.AnyAssetReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			AnyAssetReference.AnyAssetReferenceBuilder o = (AnyAssetReference.AnyAssetReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AnyAssetReference _that = getType().cast(o);
		
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
			return "AnyAssetReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
