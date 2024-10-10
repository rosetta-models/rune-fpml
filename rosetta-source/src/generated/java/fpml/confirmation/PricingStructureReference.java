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
import fpml.confirmation.PricingStructureReference;
import fpml.confirmation.PricingStructureReference.PricingStructureReferenceBuilder;
import fpml.confirmation.PricingStructureReference.PricingStructureReferenceBuilderImpl;
import fpml.confirmation.PricingStructureReference.PricingStructureReferenceImpl;
import fpml.confirmation.Reference;
import fpml.confirmation.Reference.ReferenceBuilder;
import fpml.confirmation.Reference.ReferenceBuilderImpl;
import fpml.confirmation.Reference.ReferenceImpl;
import fpml.confirmation.meta.PricingStructureReferenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Reference to a pricing structure or any derived components (i.e. yield curve).
 * @version ${project.version}
 */
@RosettaDataType(value="PricingStructureReference", builder=PricingStructureReference.PricingStructureReferenceBuilderImpl.class, version="${project.version}")
public interface PricingStructureReference extends Reference {

	PricingStructureReferenceMeta metaData = new PricingStructureReferenceMeta();

	/*********************** Getter Methods  ***********************/
	String getHref();

	/*********************** Build Methods  ***********************/
	PricingStructureReference build();
	
	PricingStructureReference.PricingStructureReferenceBuilder toBuilder();
	
	static PricingStructureReference.PricingStructureReferenceBuilder builder() {
		return new PricingStructureReference.PricingStructureReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PricingStructureReference> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PricingStructureReference> getType() {
		return PricingStructureReference.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PricingStructureReferenceBuilder extends PricingStructureReference, Reference.ReferenceBuilder {
		PricingStructureReference.PricingStructureReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		PricingStructureReference.PricingStructureReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of PricingStructureReference  ***********************/
	class PricingStructureReferenceImpl extends Reference.ReferenceImpl implements PricingStructureReference {
		private final String href;
		
		protected PricingStructureReferenceImpl(PricingStructureReference.PricingStructureReferenceBuilder builder) {
			super(builder);
			this.href = builder.getHref();
		}
		
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		public PricingStructureReference build() {
			return this;
		}
		
		@Override
		public PricingStructureReference.PricingStructureReferenceBuilder toBuilder() {
			PricingStructureReference.PricingStructureReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PricingStructureReference.PricingStructureReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PricingStructureReference _that = getType().cast(o);
		
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
			return "PricingStructureReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of PricingStructureReference  ***********************/
	class PricingStructureReferenceBuilderImpl extends Reference.ReferenceBuilderImpl  implements PricingStructureReference.PricingStructureReferenceBuilder {
	
		protected String href;
	
		public PricingStructureReferenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		@RosettaAttribute("href")
		public PricingStructureReference.PricingStructureReferenceBuilder setHref(String href) {
			this.href = href==null?null:href;
			return this;
		}
		
		@Override
		public PricingStructureReference build() {
			return new PricingStructureReference.PricingStructureReferenceImpl(this);
		}
		
		@Override
		public PricingStructureReference.PricingStructureReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PricingStructureReference.PricingStructureReferenceBuilder prune() {
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
		public PricingStructureReference.PricingStructureReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			PricingStructureReference.PricingStructureReferenceBuilder o = (PricingStructureReference.PricingStructureReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PricingStructureReference _that = getType().cast(o);
		
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
			return "PricingStructureReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
