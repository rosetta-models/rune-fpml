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
import fpml.confirmation.PricingInputReplacement;
import fpml.confirmation.PricingInputReplacement.PricingInputReplacementBuilder;
import fpml.confirmation.PricingInputReplacement.PricingInputReplacementBuilderImpl;
import fpml.confirmation.PricingInputReplacement.PricingInputReplacementImpl;
import fpml.confirmation.PricingStructureReference;
import fpml.confirmation.meta.PricingInputReplacementMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The substitution of a pricing input (e.g. curve) for another, used in generating prices and risks for valuation scenarios.
 * @version ${project.version}
 */
@RosettaDataType(value="PricingInputReplacement", builder=PricingInputReplacement.PricingInputReplacementBuilderImpl.class, version="${project.version}")
public interface PricingInputReplacement extends RosettaModelObject {

	PricingInputReplacementMeta metaData = new PricingInputReplacementMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A reference to the original value of the pricing input.
	 */
	PricingStructureReference getOriginalInputReference();
	/**
	 * A reference to the substitution to do.
	 */
	PricingStructureReference getReplacementInputReference();

	/*********************** Build Methods  ***********************/
	PricingInputReplacement build();
	
	PricingInputReplacement.PricingInputReplacementBuilder toBuilder();
	
	static PricingInputReplacement.PricingInputReplacementBuilder builder() {
		return new PricingInputReplacement.PricingInputReplacementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PricingInputReplacement> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PricingInputReplacement> getType() {
		return PricingInputReplacement.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("originalInputReference"), processor, PricingStructureReference.class, getOriginalInputReference());
		processRosetta(path.newSubPath("replacementInputReference"), processor, PricingStructureReference.class, getReplacementInputReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PricingInputReplacementBuilder extends PricingInputReplacement, RosettaModelObjectBuilder {
		PricingStructureReference.PricingStructureReferenceBuilder getOrCreateOriginalInputReference();
		PricingStructureReference.PricingStructureReferenceBuilder getOriginalInputReference();
		PricingStructureReference.PricingStructureReferenceBuilder getOrCreateReplacementInputReference();
		PricingStructureReference.PricingStructureReferenceBuilder getReplacementInputReference();
		PricingInputReplacement.PricingInputReplacementBuilder setOriginalInputReference(PricingStructureReference originalInputReference);
		PricingInputReplacement.PricingInputReplacementBuilder setReplacementInputReference(PricingStructureReference replacementInputReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("originalInputReference"), processor, PricingStructureReference.PricingStructureReferenceBuilder.class, getOriginalInputReference());
			processRosetta(path.newSubPath("replacementInputReference"), processor, PricingStructureReference.PricingStructureReferenceBuilder.class, getReplacementInputReference());
		}
		

		PricingInputReplacement.PricingInputReplacementBuilder prune();
	}

	/*********************** Immutable Implementation of PricingInputReplacement  ***********************/
	class PricingInputReplacementImpl implements PricingInputReplacement {
		private final PricingStructureReference originalInputReference;
		private final PricingStructureReference replacementInputReference;
		
		protected PricingInputReplacementImpl(PricingInputReplacement.PricingInputReplacementBuilder builder) {
			this.originalInputReference = ofNullable(builder.getOriginalInputReference()).map(f->f.build()).orElse(null);
			this.replacementInputReference = ofNullable(builder.getReplacementInputReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("originalInputReference")
		public PricingStructureReference getOriginalInputReference() {
			return originalInputReference;
		}
		
		@Override
		@RosettaAttribute("replacementInputReference")
		public PricingStructureReference getReplacementInputReference() {
			return replacementInputReference;
		}
		
		@Override
		public PricingInputReplacement build() {
			return this;
		}
		
		@Override
		public PricingInputReplacement.PricingInputReplacementBuilder toBuilder() {
			PricingInputReplacement.PricingInputReplacementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PricingInputReplacement.PricingInputReplacementBuilder builder) {
			ofNullable(getOriginalInputReference()).ifPresent(builder::setOriginalInputReference);
			ofNullable(getReplacementInputReference()).ifPresent(builder::setReplacementInputReference);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PricingInputReplacement _that = getType().cast(o);
		
			if (!Objects.equals(originalInputReference, _that.getOriginalInputReference())) return false;
			if (!Objects.equals(replacementInputReference, _that.getReplacementInputReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (originalInputReference != null ? originalInputReference.hashCode() : 0);
			_result = 31 * _result + (replacementInputReference != null ? replacementInputReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PricingInputReplacement {" +
				"originalInputReference=" + this.originalInputReference + ", " +
				"replacementInputReference=" + this.replacementInputReference +
			'}';
		}
	}

	/*********************** Builder Implementation of PricingInputReplacement  ***********************/
	class PricingInputReplacementBuilderImpl implements PricingInputReplacement.PricingInputReplacementBuilder {
	
		protected PricingStructureReference.PricingStructureReferenceBuilder originalInputReference;
		protected PricingStructureReference.PricingStructureReferenceBuilder replacementInputReference;
	
		public PricingInputReplacementBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("originalInputReference")
		public PricingStructureReference.PricingStructureReferenceBuilder getOriginalInputReference() {
			return originalInputReference;
		}
		
		@Override
		public PricingStructureReference.PricingStructureReferenceBuilder getOrCreateOriginalInputReference() {
			PricingStructureReference.PricingStructureReferenceBuilder result;
			if (originalInputReference!=null) {
				result = originalInputReference;
			}
			else {
				result = originalInputReference = PricingStructureReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("replacementInputReference")
		public PricingStructureReference.PricingStructureReferenceBuilder getReplacementInputReference() {
			return replacementInputReference;
		}
		
		@Override
		public PricingStructureReference.PricingStructureReferenceBuilder getOrCreateReplacementInputReference() {
			PricingStructureReference.PricingStructureReferenceBuilder result;
			if (replacementInputReference!=null) {
				result = replacementInputReference;
			}
			else {
				result = replacementInputReference = PricingStructureReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("originalInputReference")
		public PricingInputReplacement.PricingInputReplacementBuilder setOriginalInputReference(PricingStructureReference originalInputReference) {
			this.originalInputReference = originalInputReference==null?null:originalInputReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("replacementInputReference")
		public PricingInputReplacement.PricingInputReplacementBuilder setReplacementInputReference(PricingStructureReference replacementInputReference) {
			this.replacementInputReference = replacementInputReference==null?null:replacementInputReference.toBuilder();
			return this;
		}
		
		@Override
		public PricingInputReplacement build() {
			return new PricingInputReplacement.PricingInputReplacementImpl(this);
		}
		
		@Override
		public PricingInputReplacement.PricingInputReplacementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PricingInputReplacement.PricingInputReplacementBuilder prune() {
			if (originalInputReference!=null && !originalInputReference.prune().hasData()) originalInputReference = null;
			if (replacementInputReference!=null && !replacementInputReference.prune().hasData()) replacementInputReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getOriginalInputReference()!=null && getOriginalInputReference().hasData()) return true;
			if (getReplacementInputReference()!=null && getReplacementInputReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PricingInputReplacement.PricingInputReplacementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PricingInputReplacement.PricingInputReplacementBuilder o = (PricingInputReplacement.PricingInputReplacementBuilder) other;
			
			merger.mergeRosetta(getOriginalInputReference(), o.getOriginalInputReference(), this::setOriginalInputReference);
			merger.mergeRosetta(getReplacementInputReference(), o.getReplacementInputReference(), this::setReplacementInputReference);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PricingInputReplacement _that = getType().cast(o);
		
			if (!Objects.equals(originalInputReference, _that.getOriginalInputReference())) return false;
			if (!Objects.equals(replacementInputReference, _that.getReplacementInputReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (originalInputReference != null ? originalInputReference.hashCode() : 0);
			_result = 31 * _result + (replacementInputReference != null ? replacementInputReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PricingInputReplacementBuilder {" +
				"originalInputReference=" + this.originalInputReference + ", " +
				"replacementInputReference=" + this.replacementInputReference +
			'}';
		}
	}
}
