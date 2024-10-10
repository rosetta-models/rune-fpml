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
import fpml.confirmation.FxPivotReference;
import fpml.confirmation.FxPivotReference.FxPivotReferenceBuilder;
import fpml.confirmation.FxPivotReference.FxPivotReferenceBuilderImpl;
import fpml.confirmation.FxPivotReference.FxPivotReferenceImpl;
import fpml.confirmation.Reference;
import fpml.confirmation.Reference.ReferenceBuilder;
import fpml.confirmation.Reference.ReferenceBuilderImpl;
import fpml.confirmation.Reference.ReferenceImpl;
import fpml.confirmation.meta.FxPivotReferenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Reference to a pivot structure.
 * @version ${project.version}
 */
@RosettaDataType(value="FxPivotReference", builder=FxPivotReference.FxPivotReferenceBuilderImpl.class, version="${project.version}")
public interface FxPivotReference extends Reference {

	FxPivotReferenceMeta metaData = new FxPivotReferenceMeta();

	/*********************** Getter Methods  ***********************/
	String getHref();

	/*********************** Build Methods  ***********************/
	FxPivotReference build();
	
	FxPivotReference.FxPivotReferenceBuilder toBuilder();
	
	static FxPivotReference.FxPivotReferenceBuilder builder() {
		return new FxPivotReference.FxPivotReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxPivotReference> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxPivotReference> getType() {
		return FxPivotReference.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxPivotReferenceBuilder extends FxPivotReference, Reference.ReferenceBuilder {
		FxPivotReference.FxPivotReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		FxPivotReference.FxPivotReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of FxPivotReference  ***********************/
	class FxPivotReferenceImpl extends Reference.ReferenceImpl implements FxPivotReference {
		private final String href;
		
		protected FxPivotReferenceImpl(FxPivotReference.FxPivotReferenceBuilder builder) {
			super(builder);
			this.href = builder.getHref();
		}
		
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		public FxPivotReference build() {
			return this;
		}
		
		@Override
		public FxPivotReference.FxPivotReferenceBuilder toBuilder() {
			FxPivotReference.FxPivotReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxPivotReference.FxPivotReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxPivotReference _that = getType().cast(o);
		
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
			return "FxPivotReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxPivotReference  ***********************/
	class FxPivotReferenceBuilderImpl extends Reference.ReferenceBuilderImpl  implements FxPivotReference.FxPivotReferenceBuilder {
	
		protected String href;
	
		public FxPivotReferenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		@RosettaAttribute("href")
		public FxPivotReference.FxPivotReferenceBuilder setHref(String href) {
			this.href = href==null?null:href;
			return this;
		}
		
		@Override
		public FxPivotReference build() {
			return new FxPivotReference.FxPivotReferenceImpl(this);
		}
		
		@Override
		public FxPivotReference.FxPivotReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxPivotReference.FxPivotReferenceBuilder prune() {
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
		public FxPivotReference.FxPivotReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxPivotReference.FxPivotReferenceBuilder o = (FxPivotReference.FxPivotReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxPivotReference _that = getType().cast(o);
		
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
			return "FxPivotReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
