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
import fpml.confirmation.Reference;
import fpml.confirmation.Reference.ReferenceBuilder;
import fpml.confirmation.Reference.ReferenceBuilderImpl;
import fpml.confirmation.Reference.ReferenceImpl;
import fpml.confirmation.ValuationReference;
import fpml.confirmation.ValuationReference.ValuationReferenceBuilder;
import fpml.confirmation.ValuationReference.ValuationReferenceBuilderImpl;
import fpml.confirmation.ValuationReference.ValuationReferenceImpl;
import fpml.confirmation.meta.ValuationReferenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Reference to a Valuation or any derived structure such as PricingStructureValuation.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="ValuationReference", builder=ValuationReference.ValuationReferenceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface ValuationReference extends Reference {

	ValuationReferenceMeta metaData = new ValuationReferenceMeta();

	/*********************** Getter Methods  ***********************/
	String getHref();

	/*********************** Build Methods  ***********************/
	ValuationReference build();
	
	ValuationReference.ValuationReferenceBuilder toBuilder();
	
	static ValuationReference.ValuationReferenceBuilder builder() {
		return new ValuationReference.ValuationReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ValuationReference> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ValuationReference> getType() {
		return ValuationReference.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ValuationReferenceBuilder extends ValuationReference, Reference.ReferenceBuilder {
		ValuationReference.ValuationReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		ValuationReference.ValuationReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of ValuationReference  ***********************/
	class ValuationReferenceImpl extends Reference.ReferenceImpl implements ValuationReference {
		private final String href;
		
		protected ValuationReferenceImpl(ValuationReference.ValuationReferenceBuilder builder) {
			super(builder);
			this.href = builder.getHref();
		}
		
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		public ValuationReference build() {
			return this;
		}
		
		@Override
		public ValuationReference.ValuationReferenceBuilder toBuilder() {
			ValuationReference.ValuationReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ValuationReference.ValuationReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ValuationReference _that = getType().cast(o);
		
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
			return "ValuationReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ValuationReference  ***********************/
	class ValuationReferenceBuilderImpl extends Reference.ReferenceBuilderImpl  implements ValuationReference.ValuationReferenceBuilder {
	
		protected String href;
	
		public ValuationReferenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		@RosettaAttribute("href")
		public ValuationReference.ValuationReferenceBuilder setHref(String href) {
			this.href = href==null?null:href;
			return this;
		}
		
		@Override
		public ValuationReference build() {
			return new ValuationReference.ValuationReferenceImpl(this);
		}
		
		@Override
		public ValuationReference.ValuationReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ValuationReference.ValuationReferenceBuilder prune() {
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
		public ValuationReference.ValuationReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ValuationReference.ValuationReferenceBuilder o = (ValuationReference.ValuationReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ValuationReference _that = getType().cast(o);
		
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
			return "ValuationReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
