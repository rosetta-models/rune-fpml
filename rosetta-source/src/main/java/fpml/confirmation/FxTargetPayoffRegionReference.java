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
import fpml.confirmation.FxTargetPayoffRegionReference;
import fpml.confirmation.FxTargetPayoffRegionReference.FxTargetPayoffRegionReferenceBuilder;
import fpml.confirmation.FxTargetPayoffRegionReference.FxTargetPayoffRegionReferenceBuilderImpl;
import fpml.confirmation.FxTargetPayoffRegionReference.FxTargetPayoffRegionReferenceImpl;
import fpml.confirmation.Reference;
import fpml.confirmation.Reference.ReferenceBuilder;
import fpml.confirmation.Reference.ReferenceBuilderImpl;
import fpml.confirmation.Reference.ReferenceImpl;
import fpml.confirmation.meta.FxTargetPayoffRegionReferenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Reference to a FX Target Payoff Region.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FxTargetPayoffRegionReference", builder=FxTargetPayoffRegionReference.FxTargetPayoffRegionReferenceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FxTargetPayoffRegionReference extends Reference {

	FxTargetPayoffRegionReferenceMeta metaData = new FxTargetPayoffRegionReferenceMeta();

	/*********************** Getter Methods  ***********************/
	String getHref();

	/*********************** Build Methods  ***********************/
	FxTargetPayoffRegionReference build();
	
	FxTargetPayoffRegionReference.FxTargetPayoffRegionReferenceBuilder toBuilder();
	
	static FxTargetPayoffRegionReference.FxTargetPayoffRegionReferenceBuilder builder() {
		return new FxTargetPayoffRegionReference.FxTargetPayoffRegionReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxTargetPayoffRegionReference> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxTargetPayoffRegionReference> getType() {
		return FxTargetPayoffRegionReference.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxTargetPayoffRegionReferenceBuilder extends FxTargetPayoffRegionReference, Reference.ReferenceBuilder {
		FxTargetPayoffRegionReference.FxTargetPayoffRegionReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		FxTargetPayoffRegionReference.FxTargetPayoffRegionReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of FxTargetPayoffRegionReference  ***********************/
	class FxTargetPayoffRegionReferenceImpl extends Reference.ReferenceImpl implements FxTargetPayoffRegionReference {
		private final String href;
		
		protected FxTargetPayoffRegionReferenceImpl(FxTargetPayoffRegionReference.FxTargetPayoffRegionReferenceBuilder builder) {
			super(builder);
			this.href = builder.getHref();
		}
		
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		public FxTargetPayoffRegionReference build() {
			return this;
		}
		
		@Override
		public FxTargetPayoffRegionReference.FxTargetPayoffRegionReferenceBuilder toBuilder() {
			FxTargetPayoffRegionReference.FxTargetPayoffRegionReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxTargetPayoffRegionReference.FxTargetPayoffRegionReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxTargetPayoffRegionReference _that = getType().cast(o);
		
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
			return "FxTargetPayoffRegionReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxTargetPayoffRegionReference  ***********************/
	class FxTargetPayoffRegionReferenceBuilderImpl extends Reference.ReferenceBuilderImpl  implements FxTargetPayoffRegionReference.FxTargetPayoffRegionReferenceBuilder {
	
		protected String href;
	
		public FxTargetPayoffRegionReferenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		@RosettaAttribute("href")
		public FxTargetPayoffRegionReference.FxTargetPayoffRegionReferenceBuilder setHref(String href) {
			this.href = href==null?null:href;
			return this;
		}
		
		@Override
		public FxTargetPayoffRegionReference build() {
			return new FxTargetPayoffRegionReference.FxTargetPayoffRegionReferenceImpl(this);
		}
		
		@Override
		public FxTargetPayoffRegionReference.FxTargetPayoffRegionReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetPayoffRegionReference.FxTargetPayoffRegionReferenceBuilder prune() {
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
		public FxTargetPayoffRegionReference.FxTargetPayoffRegionReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxTargetPayoffRegionReference.FxTargetPayoffRegionReferenceBuilder o = (FxTargetPayoffRegionReference.FxTargetPayoffRegionReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxTargetPayoffRegionReference _that = getType().cast(o);
		
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
			return "FxTargetPayoffRegionReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
