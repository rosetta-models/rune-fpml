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
import fpml.confirmation.LegalEntity;
import fpml.confirmation.LegalEntityReference;
import fpml.confirmation.ReferenceObligationChoice;
import fpml.confirmation.ReferenceObligationChoice.ReferenceObligationChoiceBuilder;
import fpml.confirmation.ReferenceObligationChoice.ReferenceObligationChoiceBuilderImpl;
import fpml.confirmation.ReferenceObligationChoice.ReferenceObligationChoiceImpl;
import fpml.confirmation.meta.ReferenceObligationChoiceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="ReferenceObligationChoice", builder=ReferenceObligationChoice.ReferenceObligationChoiceBuilderImpl.class, version="${project.version}")
public interface ReferenceObligationChoice extends RosettaModelObject {

	ReferenceObligationChoiceMeta metaData = new ReferenceObligationChoiceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The party that guarantees by way of a contractual arrangement to pay the debts of an obligor if the obligor is unable to make the required payments itself. ISDA 2003 Term: Guarantor
	 */
	LegalEntity getGuarantor();
	/**
	 * A pointer style reference to a reference entity defined elsewhere in the document. Used when the reference entity is the guarantor.
	 */
	LegalEntityReference getGuarantorReference();

	/*********************** Build Methods  ***********************/
	ReferenceObligationChoice build();
	
	ReferenceObligationChoice.ReferenceObligationChoiceBuilder toBuilder();
	
	static ReferenceObligationChoice.ReferenceObligationChoiceBuilder builder() {
		return new ReferenceObligationChoice.ReferenceObligationChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReferenceObligationChoice> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ReferenceObligationChoice> getType() {
		return ReferenceObligationChoice.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("guarantor"), processor, LegalEntity.class, getGuarantor());
		processRosetta(path.newSubPath("guarantorReference"), processor, LegalEntityReference.class, getGuarantorReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReferenceObligationChoiceBuilder extends ReferenceObligationChoice, RosettaModelObjectBuilder {
		LegalEntity.LegalEntityBuilder getOrCreateGuarantor();
		LegalEntity.LegalEntityBuilder getGuarantor();
		LegalEntityReference.LegalEntityReferenceBuilder getOrCreateGuarantorReference();
		LegalEntityReference.LegalEntityReferenceBuilder getGuarantorReference();
		ReferenceObligationChoice.ReferenceObligationChoiceBuilder setGuarantor(LegalEntity guarantor);
		ReferenceObligationChoice.ReferenceObligationChoiceBuilder setGuarantorReference(LegalEntityReference guarantorReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("guarantor"), processor, LegalEntity.LegalEntityBuilder.class, getGuarantor());
			processRosetta(path.newSubPath("guarantorReference"), processor, LegalEntityReference.LegalEntityReferenceBuilder.class, getGuarantorReference());
		}
		

		ReferenceObligationChoice.ReferenceObligationChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of ReferenceObligationChoice  ***********************/
	class ReferenceObligationChoiceImpl implements ReferenceObligationChoice {
		private final LegalEntity guarantor;
		private final LegalEntityReference guarantorReference;
		
		protected ReferenceObligationChoiceImpl(ReferenceObligationChoice.ReferenceObligationChoiceBuilder builder) {
			this.guarantor = ofNullable(builder.getGuarantor()).map(f->f.build()).orElse(null);
			this.guarantorReference = ofNullable(builder.getGuarantorReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("guarantor")
		public LegalEntity getGuarantor() {
			return guarantor;
		}
		
		@Override
		@RosettaAttribute("guarantorReference")
		public LegalEntityReference getGuarantorReference() {
			return guarantorReference;
		}
		
		@Override
		public ReferenceObligationChoice build() {
			return this;
		}
		
		@Override
		public ReferenceObligationChoice.ReferenceObligationChoiceBuilder toBuilder() {
			ReferenceObligationChoice.ReferenceObligationChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReferenceObligationChoice.ReferenceObligationChoiceBuilder builder) {
			ofNullable(getGuarantor()).ifPresent(builder::setGuarantor);
			ofNullable(getGuarantorReference()).ifPresent(builder::setGuarantorReference);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferenceObligationChoice _that = getType().cast(o);
		
			if (!Objects.equals(guarantor, _that.getGuarantor())) return false;
			if (!Objects.equals(guarantorReference, _that.getGuarantorReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (guarantor != null ? guarantor.hashCode() : 0);
			_result = 31 * _result + (guarantorReference != null ? guarantorReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReferenceObligationChoice {" +
				"guarantor=" + this.guarantor + ", " +
				"guarantorReference=" + this.guarantorReference +
			'}';
		}
	}

	/*********************** Builder Implementation of ReferenceObligationChoice  ***********************/
	class ReferenceObligationChoiceBuilderImpl implements ReferenceObligationChoice.ReferenceObligationChoiceBuilder {
	
		protected LegalEntity.LegalEntityBuilder guarantor;
		protected LegalEntityReference.LegalEntityReferenceBuilder guarantorReference;
	
		public ReferenceObligationChoiceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("guarantor")
		public LegalEntity.LegalEntityBuilder getGuarantor() {
			return guarantor;
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder getOrCreateGuarantor() {
			LegalEntity.LegalEntityBuilder result;
			if (guarantor!=null) {
				result = guarantor;
			}
			else {
				result = guarantor = LegalEntity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("guarantorReference")
		public LegalEntityReference.LegalEntityReferenceBuilder getGuarantorReference() {
			return guarantorReference;
		}
		
		@Override
		public LegalEntityReference.LegalEntityReferenceBuilder getOrCreateGuarantorReference() {
			LegalEntityReference.LegalEntityReferenceBuilder result;
			if (guarantorReference!=null) {
				result = guarantorReference;
			}
			else {
				result = guarantorReference = LegalEntityReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("guarantor")
		public ReferenceObligationChoice.ReferenceObligationChoiceBuilder setGuarantor(LegalEntity guarantor) {
			this.guarantor = guarantor==null?null:guarantor.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("guarantorReference")
		public ReferenceObligationChoice.ReferenceObligationChoiceBuilder setGuarantorReference(LegalEntityReference guarantorReference) {
			this.guarantorReference = guarantorReference==null?null:guarantorReference.toBuilder();
			return this;
		}
		
		@Override
		public ReferenceObligationChoice build() {
			return new ReferenceObligationChoice.ReferenceObligationChoiceImpl(this);
		}
		
		@Override
		public ReferenceObligationChoice.ReferenceObligationChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceObligationChoice.ReferenceObligationChoiceBuilder prune() {
			if (guarantor!=null && !guarantor.prune().hasData()) guarantor = null;
			if (guarantorReference!=null && !guarantorReference.prune().hasData()) guarantorReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getGuarantor()!=null && getGuarantor().hasData()) return true;
			if (getGuarantorReference()!=null && getGuarantorReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceObligationChoice.ReferenceObligationChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReferenceObligationChoice.ReferenceObligationChoiceBuilder o = (ReferenceObligationChoice.ReferenceObligationChoiceBuilder) other;
			
			merger.mergeRosetta(getGuarantor(), o.getGuarantor(), this::setGuarantor);
			merger.mergeRosetta(getGuarantorReference(), o.getGuarantorReference(), this::setGuarantorReference);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferenceObligationChoice _that = getType().cast(o);
		
			if (!Objects.equals(guarantor, _that.getGuarantor())) return false;
			if (!Objects.equals(guarantorReference, _that.getGuarantorReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (guarantor != null ? guarantor.hashCode() : 0);
			_result = 31 * _result + (guarantorReference != null ? guarantorReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReferenceObligationChoiceBuilder {" +
				"guarantor=" + this.guarantor + ", " +
				"guarantorReference=" + this.guarantorReference +
			'}';
		}
	}
}
