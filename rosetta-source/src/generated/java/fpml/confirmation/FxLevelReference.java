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
import fpml.confirmation.FxLevelReference;
import fpml.confirmation.FxLevelReference.FxLevelReferenceBuilder;
import fpml.confirmation.FxLevelReference.FxLevelReferenceBuilderImpl;
import fpml.confirmation.FxLevelReference.FxLevelReferenceImpl;
import fpml.confirmation.Reference;
import fpml.confirmation.Reference.ReferenceBuilder;
import fpml.confirmation.Reference.ReferenceBuilderImpl;
import fpml.confirmation.Reference.ReferenceImpl;
import fpml.confirmation.meta.FxLevelReferenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Reference to a level structure.
 * @version ${project.version}
 */
@RosettaDataType(value="FxLevelReference", builder=FxLevelReference.FxLevelReferenceBuilderImpl.class, version="${project.version}")
public interface FxLevelReference extends Reference {

	FxLevelReferenceMeta metaData = new FxLevelReferenceMeta();

	/*********************** Getter Methods  ***********************/
	String getHref();

	/*********************** Build Methods  ***********************/
	FxLevelReference build();
	
	FxLevelReference.FxLevelReferenceBuilder toBuilder();
	
	static FxLevelReference.FxLevelReferenceBuilder builder() {
		return new FxLevelReference.FxLevelReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxLevelReference> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxLevelReference> getType() {
		return FxLevelReference.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxLevelReferenceBuilder extends FxLevelReference, Reference.ReferenceBuilder {
		FxLevelReference.FxLevelReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		FxLevelReference.FxLevelReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of FxLevelReference  ***********************/
	class FxLevelReferenceImpl extends Reference.ReferenceImpl implements FxLevelReference {
		private final String href;
		
		protected FxLevelReferenceImpl(FxLevelReference.FxLevelReferenceBuilder builder) {
			super(builder);
			this.href = builder.getHref();
		}
		
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		public FxLevelReference build() {
			return this;
		}
		
		@Override
		public FxLevelReference.FxLevelReferenceBuilder toBuilder() {
			FxLevelReference.FxLevelReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxLevelReference.FxLevelReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxLevelReference _that = getType().cast(o);
		
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
			return "FxLevelReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxLevelReference  ***********************/
	class FxLevelReferenceBuilderImpl extends Reference.ReferenceBuilderImpl  implements FxLevelReference.FxLevelReferenceBuilder {
	
		protected String href;
	
		public FxLevelReferenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		@RosettaAttribute("href")
		public FxLevelReference.FxLevelReferenceBuilder setHref(String href) {
			this.href = href==null?null:href;
			return this;
		}
		
		@Override
		public FxLevelReference build() {
			return new FxLevelReference.FxLevelReferenceImpl(this);
		}
		
		@Override
		public FxLevelReference.FxLevelReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxLevelReference.FxLevelReferenceBuilder prune() {
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
		public FxLevelReference.FxLevelReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxLevelReference.FxLevelReferenceBuilder o = (FxLevelReference.FxLevelReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxLevelReference _that = getType().cast(o);
		
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
			return "FxLevelReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
