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
import fpml.confirmation.FxComplexBarrierBaseReference;
import fpml.confirmation.FxComplexBarrierBaseReference.FxComplexBarrierBaseReferenceBuilder;
import fpml.confirmation.FxComplexBarrierBaseReference.FxComplexBarrierBaseReferenceBuilderImpl;
import fpml.confirmation.FxComplexBarrierBaseReference.FxComplexBarrierBaseReferenceImpl;
import fpml.confirmation.Reference;
import fpml.confirmation.Reference.ReferenceBuilder;
import fpml.confirmation.Reference.ReferenceBuilderImpl;
import fpml.confirmation.Reference.ReferenceImpl;
import fpml.confirmation.meta.FxComplexBarrierBaseReferenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Reference to a barrier structure defined within the parametric representation.
 * @version ${project.version}
 */
@RosettaDataType(value="FxComplexBarrierBaseReference", builder=FxComplexBarrierBaseReference.FxComplexBarrierBaseReferenceBuilderImpl.class, version="${project.version}")
public interface FxComplexBarrierBaseReference extends Reference {

	FxComplexBarrierBaseReferenceMeta metaData = new FxComplexBarrierBaseReferenceMeta();

	/*********************** Getter Methods  ***********************/
	String getHref();

	/*********************** Build Methods  ***********************/
	FxComplexBarrierBaseReference build();
	
	FxComplexBarrierBaseReference.FxComplexBarrierBaseReferenceBuilder toBuilder();
	
	static FxComplexBarrierBaseReference.FxComplexBarrierBaseReferenceBuilder builder() {
		return new FxComplexBarrierBaseReference.FxComplexBarrierBaseReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxComplexBarrierBaseReference> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxComplexBarrierBaseReference> getType() {
		return FxComplexBarrierBaseReference.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxComplexBarrierBaseReferenceBuilder extends FxComplexBarrierBaseReference, Reference.ReferenceBuilder {
		FxComplexBarrierBaseReference.FxComplexBarrierBaseReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		FxComplexBarrierBaseReference.FxComplexBarrierBaseReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of FxComplexBarrierBaseReference  ***********************/
	class FxComplexBarrierBaseReferenceImpl extends Reference.ReferenceImpl implements FxComplexBarrierBaseReference {
		private final String href;
		
		protected FxComplexBarrierBaseReferenceImpl(FxComplexBarrierBaseReference.FxComplexBarrierBaseReferenceBuilder builder) {
			super(builder);
			this.href = builder.getHref();
		}
		
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		public FxComplexBarrierBaseReference build() {
			return this;
		}
		
		@Override
		public FxComplexBarrierBaseReference.FxComplexBarrierBaseReferenceBuilder toBuilder() {
			FxComplexBarrierBaseReference.FxComplexBarrierBaseReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxComplexBarrierBaseReference.FxComplexBarrierBaseReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxComplexBarrierBaseReference _that = getType().cast(o);
		
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
			return "FxComplexBarrierBaseReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxComplexBarrierBaseReference  ***********************/
	class FxComplexBarrierBaseReferenceBuilderImpl extends Reference.ReferenceBuilderImpl  implements FxComplexBarrierBaseReference.FxComplexBarrierBaseReferenceBuilder {
	
		protected String href;
	
		public FxComplexBarrierBaseReferenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		@RosettaAttribute("href")
		public FxComplexBarrierBaseReference.FxComplexBarrierBaseReferenceBuilder setHref(String href) {
			this.href = href==null?null:href;
			return this;
		}
		
		@Override
		public FxComplexBarrierBaseReference build() {
			return new FxComplexBarrierBaseReference.FxComplexBarrierBaseReferenceImpl(this);
		}
		
		@Override
		public FxComplexBarrierBaseReference.FxComplexBarrierBaseReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxComplexBarrierBaseReference.FxComplexBarrierBaseReferenceBuilder prune() {
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
		public FxComplexBarrierBaseReference.FxComplexBarrierBaseReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxComplexBarrierBaseReference.FxComplexBarrierBaseReferenceBuilder o = (FxComplexBarrierBaseReference.FxComplexBarrierBaseReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxComplexBarrierBaseReference _that = getType().cast(o);
		
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
			return "FxComplexBarrierBaseReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
