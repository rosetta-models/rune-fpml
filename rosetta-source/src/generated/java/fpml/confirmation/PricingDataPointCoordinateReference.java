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
import fpml.confirmation.PricingDataPointCoordinateReference;
import fpml.confirmation.PricingDataPointCoordinateReference.PricingDataPointCoordinateReferenceBuilder;
import fpml.confirmation.PricingDataPointCoordinateReference.PricingDataPointCoordinateReferenceBuilderImpl;
import fpml.confirmation.PricingDataPointCoordinateReference.PricingDataPointCoordinateReferenceImpl;
import fpml.confirmation.Reference;
import fpml.confirmation.Reference.ReferenceBuilder;
import fpml.confirmation.Reference.ReferenceBuilderImpl;
import fpml.confirmation.Reference.ReferenceImpl;
import fpml.confirmation.meta.PricingDataPointCoordinateReferenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Reference to a Pricing Data Point Coordinate.
 * @version ${project.version}
 */
@RosettaDataType(value="PricingDataPointCoordinateReference", builder=PricingDataPointCoordinateReference.PricingDataPointCoordinateReferenceBuilderImpl.class, version="${project.version}")
public interface PricingDataPointCoordinateReference extends Reference {

	PricingDataPointCoordinateReferenceMeta metaData = new PricingDataPointCoordinateReferenceMeta();

	/*********************** Getter Methods  ***********************/
	String getHref();

	/*********************** Build Methods  ***********************/
	PricingDataPointCoordinateReference build();
	
	PricingDataPointCoordinateReference.PricingDataPointCoordinateReferenceBuilder toBuilder();
	
	static PricingDataPointCoordinateReference.PricingDataPointCoordinateReferenceBuilder builder() {
		return new PricingDataPointCoordinateReference.PricingDataPointCoordinateReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PricingDataPointCoordinateReference> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PricingDataPointCoordinateReference> getType() {
		return PricingDataPointCoordinateReference.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PricingDataPointCoordinateReferenceBuilder extends PricingDataPointCoordinateReference, Reference.ReferenceBuilder {
		PricingDataPointCoordinateReference.PricingDataPointCoordinateReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		PricingDataPointCoordinateReference.PricingDataPointCoordinateReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of PricingDataPointCoordinateReference  ***********************/
	class PricingDataPointCoordinateReferenceImpl extends Reference.ReferenceImpl implements PricingDataPointCoordinateReference {
		private final String href;
		
		protected PricingDataPointCoordinateReferenceImpl(PricingDataPointCoordinateReference.PricingDataPointCoordinateReferenceBuilder builder) {
			super(builder);
			this.href = builder.getHref();
		}
		
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		public PricingDataPointCoordinateReference build() {
			return this;
		}
		
		@Override
		public PricingDataPointCoordinateReference.PricingDataPointCoordinateReferenceBuilder toBuilder() {
			PricingDataPointCoordinateReference.PricingDataPointCoordinateReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PricingDataPointCoordinateReference.PricingDataPointCoordinateReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PricingDataPointCoordinateReference _that = getType().cast(o);
		
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
			return "PricingDataPointCoordinateReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of PricingDataPointCoordinateReference  ***********************/
	class PricingDataPointCoordinateReferenceBuilderImpl extends Reference.ReferenceBuilderImpl  implements PricingDataPointCoordinateReference.PricingDataPointCoordinateReferenceBuilder {
	
		protected String href;
	
		public PricingDataPointCoordinateReferenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		@RosettaAttribute("href")
		public PricingDataPointCoordinateReference.PricingDataPointCoordinateReferenceBuilder setHref(String href) {
			this.href = href==null?null:href;
			return this;
		}
		
		@Override
		public PricingDataPointCoordinateReference build() {
			return new PricingDataPointCoordinateReference.PricingDataPointCoordinateReferenceImpl(this);
		}
		
		@Override
		public PricingDataPointCoordinateReference.PricingDataPointCoordinateReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PricingDataPointCoordinateReference.PricingDataPointCoordinateReferenceBuilder prune() {
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
		public PricingDataPointCoordinateReference.PricingDataPointCoordinateReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			PricingDataPointCoordinateReference.PricingDataPointCoordinateReferenceBuilder o = (PricingDataPointCoordinateReference.PricingDataPointCoordinateReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PricingDataPointCoordinateReference _that = getType().cast(o);
		
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
			return "PricingDataPointCoordinateReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
