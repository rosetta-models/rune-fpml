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
import fpml.confirmation.FxTargetReference;
import fpml.confirmation.FxTargetReference.FxTargetReferenceBuilder;
import fpml.confirmation.FxTargetReference.FxTargetReferenceBuilderImpl;
import fpml.confirmation.FxTargetReference.FxTargetReferenceImpl;
import fpml.confirmation.Reference;
import fpml.confirmation.Reference.ReferenceBuilder;
import fpml.confirmation.Reference.ReferenceBuilderImpl;
import fpml.confirmation.Reference.ReferenceImpl;
import fpml.confirmation.meta.FxTargetReferenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Reference to a target structure.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FxTargetReference", builder=FxTargetReference.FxTargetReferenceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FxTargetReference extends Reference {

	FxTargetReferenceMeta metaData = new FxTargetReferenceMeta();

	/*********************** Getter Methods  ***********************/
	String getHref();

	/*********************** Build Methods  ***********************/
	FxTargetReference build();
	
	FxTargetReference.FxTargetReferenceBuilder toBuilder();
	
	static FxTargetReference.FxTargetReferenceBuilder builder() {
		return new FxTargetReference.FxTargetReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxTargetReference> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxTargetReference> getType() {
		return FxTargetReference.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxTargetReferenceBuilder extends FxTargetReference, Reference.ReferenceBuilder {
		FxTargetReference.FxTargetReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		FxTargetReference.FxTargetReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of FxTargetReference  ***********************/
	class FxTargetReferenceImpl extends Reference.ReferenceImpl implements FxTargetReference {
		private final String href;
		
		protected FxTargetReferenceImpl(FxTargetReference.FxTargetReferenceBuilder builder) {
			super(builder);
			this.href = builder.getHref();
		}
		
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		public FxTargetReference build() {
			return this;
		}
		
		@Override
		public FxTargetReference.FxTargetReferenceBuilder toBuilder() {
			FxTargetReference.FxTargetReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxTargetReference.FxTargetReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxTargetReference _that = getType().cast(o);
		
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
			return "FxTargetReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxTargetReference  ***********************/
	class FxTargetReferenceBuilderImpl extends Reference.ReferenceBuilderImpl  implements FxTargetReference.FxTargetReferenceBuilder {
	
		protected String href;
	
		public FxTargetReferenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		@RosettaAttribute("href")
		public FxTargetReference.FxTargetReferenceBuilder setHref(String href) {
			this.href = href==null?null:href;
			return this;
		}
		
		@Override
		public FxTargetReference build() {
			return new FxTargetReference.FxTargetReferenceImpl(this);
		}
		
		@Override
		public FxTargetReference.FxTargetReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetReference.FxTargetReferenceBuilder prune() {
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
		public FxTargetReference.FxTargetReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxTargetReference.FxTargetReferenceBuilder o = (FxTargetReference.FxTargetReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxTargetReference _that = getType().cast(o);
		
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
			return "FxTargetReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
