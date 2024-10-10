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
import fpml.confirmation.FxAccrualPayoffRegionReference;
import fpml.confirmation.FxAccrualPayoffRegionReference.FxAccrualPayoffRegionReferenceBuilder;
import fpml.confirmation.FxAccrualPayoffRegionReference.FxAccrualPayoffRegionReferenceBuilderImpl;
import fpml.confirmation.FxAccrualPayoffRegionReference.FxAccrualPayoffRegionReferenceImpl;
import fpml.confirmation.Reference;
import fpml.confirmation.Reference.ReferenceBuilder;
import fpml.confirmation.Reference.ReferenceBuilderImpl;
import fpml.confirmation.Reference.ReferenceImpl;
import fpml.confirmation.meta.FxAccrualPayoffRegionReferenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Reference to a FX Accrual Payoff Region.
 * @version ${project.version}
 */
@RosettaDataType(value="FxAccrualPayoffRegionReference", builder=FxAccrualPayoffRegionReference.FxAccrualPayoffRegionReferenceBuilderImpl.class, version="${project.version}")
public interface FxAccrualPayoffRegionReference extends Reference {

	FxAccrualPayoffRegionReferenceMeta metaData = new FxAccrualPayoffRegionReferenceMeta();

	/*********************** Getter Methods  ***********************/
	String getHref();

	/*********************** Build Methods  ***********************/
	FxAccrualPayoffRegionReference build();
	
	FxAccrualPayoffRegionReference.FxAccrualPayoffRegionReferenceBuilder toBuilder();
	
	static FxAccrualPayoffRegionReference.FxAccrualPayoffRegionReferenceBuilder builder() {
		return new FxAccrualPayoffRegionReference.FxAccrualPayoffRegionReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAccrualPayoffRegionReference> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxAccrualPayoffRegionReference> getType() {
		return FxAccrualPayoffRegionReference.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxAccrualPayoffRegionReferenceBuilder extends FxAccrualPayoffRegionReference, Reference.ReferenceBuilder {
		FxAccrualPayoffRegionReference.FxAccrualPayoffRegionReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		FxAccrualPayoffRegionReference.FxAccrualPayoffRegionReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of FxAccrualPayoffRegionReference  ***********************/
	class FxAccrualPayoffRegionReferenceImpl extends Reference.ReferenceImpl implements FxAccrualPayoffRegionReference {
		private final String href;
		
		protected FxAccrualPayoffRegionReferenceImpl(FxAccrualPayoffRegionReference.FxAccrualPayoffRegionReferenceBuilder builder) {
			super(builder);
			this.href = builder.getHref();
		}
		
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		public FxAccrualPayoffRegionReference build() {
			return this;
		}
		
		@Override
		public FxAccrualPayoffRegionReference.FxAccrualPayoffRegionReferenceBuilder toBuilder() {
			FxAccrualPayoffRegionReference.FxAccrualPayoffRegionReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAccrualPayoffRegionReference.FxAccrualPayoffRegionReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxAccrualPayoffRegionReference _that = getType().cast(o);
		
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
			return "FxAccrualPayoffRegionReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxAccrualPayoffRegionReference  ***********************/
	class FxAccrualPayoffRegionReferenceBuilderImpl extends Reference.ReferenceBuilderImpl  implements FxAccrualPayoffRegionReference.FxAccrualPayoffRegionReferenceBuilder {
	
		protected String href;
	
		public FxAccrualPayoffRegionReferenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		@RosettaAttribute("href")
		public FxAccrualPayoffRegionReference.FxAccrualPayoffRegionReferenceBuilder setHref(String href) {
			this.href = href==null?null:href;
			return this;
		}
		
		@Override
		public FxAccrualPayoffRegionReference build() {
			return new FxAccrualPayoffRegionReference.FxAccrualPayoffRegionReferenceImpl(this);
		}
		
		@Override
		public FxAccrualPayoffRegionReference.FxAccrualPayoffRegionReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualPayoffRegionReference.FxAccrualPayoffRegionReferenceBuilder prune() {
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
		public FxAccrualPayoffRegionReference.FxAccrualPayoffRegionReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxAccrualPayoffRegionReference.FxAccrualPayoffRegionReferenceBuilder o = (FxAccrualPayoffRegionReference.FxAccrualPayoffRegionReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxAccrualPayoffRegionReference _that = getType().cast(o);
		
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
			return "FxAccrualPayoffRegionReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
