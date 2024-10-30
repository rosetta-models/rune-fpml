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
import fpml.confirmation.PartyReference;
import fpml.confirmation.SwaptionPhysicalSettlement;
import fpml.confirmation.SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder;
import fpml.confirmation.SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilderImpl;
import fpml.confirmation.SwaptionPhysicalSettlement.SwaptionPhysicalSettlementImpl;
import fpml.confirmation.meta.SwaptionPhysicalSettlementMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="SwaptionPhysicalSettlement", builder=SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface SwaptionPhysicalSettlement extends RosettaModelObject {

	SwaptionPhysicalSettlementMeta metaData = new SwaptionPhysicalSettlementMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies whether the swap resulting from physical settlement of the swaption transaction will clear through a clearing house. The meaning of Cleared Physical Settlement is defined in the 2006 ISDA Definitions, Section 15.2 (published in Supplement number 28).
	 */
	Boolean getClearedPhysicalSettlement();
	/**
	 * A reference to the clearing organization (CCP, DCO) to which the trade should be cleared.
	 */
	PartyReference getPredeterminedClearingOrganizationPartyReference();

	/*********************** Build Methods  ***********************/
	SwaptionPhysicalSettlement build();
	
	SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder toBuilder();
	
	static SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder builder() {
		return new SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SwaptionPhysicalSettlement> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends SwaptionPhysicalSettlement> getType() {
		return SwaptionPhysicalSettlement.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("clearedPhysicalSettlement"), Boolean.class, getClearedPhysicalSettlement(), this);
		processRosetta(path.newSubPath("predeterminedClearingOrganizationPartyReference"), processor, PartyReference.class, getPredeterminedClearingOrganizationPartyReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SwaptionPhysicalSettlementBuilder extends SwaptionPhysicalSettlement, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreatePredeterminedClearingOrganizationPartyReference();
		PartyReference.PartyReferenceBuilder getPredeterminedClearingOrganizationPartyReference();
		SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder setClearedPhysicalSettlement(Boolean clearedPhysicalSettlement);
		SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder setPredeterminedClearingOrganizationPartyReference(PartyReference predeterminedClearingOrganizationPartyReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("clearedPhysicalSettlement"), Boolean.class, getClearedPhysicalSettlement(), this);
			processRosetta(path.newSubPath("predeterminedClearingOrganizationPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPredeterminedClearingOrganizationPartyReference());
		}
		

		SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder prune();
	}

	/*********************** Immutable Implementation of SwaptionPhysicalSettlement  ***********************/
	class SwaptionPhysicalSettlementImpl implements SwaptionPhysicalSettlement {
		private final Boolean clearedPhysicalSettlement;
		private final PartyReference predeterminedClearingOrganizationPartyReference;
		
		protected SwaptionPhysicalSettlementImpl(SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder builder) {
			this.clearedPhysicalSettlement = builder.getClearedPhysicalSettlement();
			this.predeterminedClearingOrganizationPartyReference = ofNullable(builder.getPredeterminedClearingOrganizationPartyReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("clearedPhysicalSettlement")
		public Boolean getClearedPhysicalSettlement() {
			return clearedPhysicalSettlement;
		}
		
		@Override
		@RosettaAttribute("predeterminedClearingOrganizationPartyReference")
		public PartyReference getPredeterminedClearingOrganizationPartyReference() {
			return predeterminedClearingOrganizationPartyReference;
		}
		
		@Override
		public SwaptionPhysicalSettlement build() {
			return this;
		}
		
		@Override
		public SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder toBuilder() {
			SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder builder) {
			ofNullable(getClearedPhysicalSettlement()).ifPresent(builder::setClearedPhysicalSettlement);
			ofNullable(getPredeterminedClearingOrganizationPartyReference()).ifPresent(builder::setPredeterminedClearingOrganizationPartyReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SwaptionPhysicalSettlement _that = getType().cast(o);
		
			if (!Objects.equals(clearedPhysicalSettlement, _that.getClearedPhysicalSettlement())) return false;
			if (!Objects.equals(predeterminedClearingOrganizationPartyReference, _that.getPredeterminedClearingOrganizationPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (clearedPhysicalSettlement != null ? clearedPhysicalSettlement.hashCode() : 0);
			_result = 31 * _result + (predeterminedClearingOrganizationPartyReference != null ? predeterminedClearingOrganizationPartyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SwaptionPhysicalSettlement {" +
				"clearedPhysicalSettlement=" + this.clearedPhysicalSettlement + ", " +
				"predeterminedClearingOrganizationPartyReference=" + this.predeterminedClearingOrganizationPartyReference +
			'}';
		}
	}

	/*********************** Builder Implementation of SwaptionPhysicalSettlement  ***********************/
	class SwaptionPhysicalSettlementBuilderImpl implements SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder {
	
		protected Boolean clearedPhysicalSettlement;
		protected PartyReference.PartyReferenceBuilder predeterminedClearingOrganizationPartyReference;
	
		public SwaptionPhysicalSettlementBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("clearedPhysicalSettlement")
		public Boolean getClearedPhysicalSettlement() {
			return clearedPhysicalSettlement;
		}
		
		@Override
		@RosettaAttribute("predeterminedClearingOrganizationPartyReference")
		public PartyReference.PartyReferenceBuilder getPredeterminedClearingOrganizationPartyReference() {
			return predeterminedClearingOrganizationPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreatePredeterminedClearingOrganizationPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (predeterminedClearingOrganizationPartyReference!=null) {
				result = predeterminedClearingOrganizationPartyReference;
			}
			else {
				result = predeterminedClearingOrganizationPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("clearedPhysicalSettlement")
		public SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder setClearedPhysicalSettlement(Boolean clearedPhysicalSettlement) {
			this.clearedPhysicalSettlement = clearedPhysicalSettlement==null?null:clearedPhysicalSettlement;
			return this;
		}
		@Override
		@RosettaAttribute("predeterminedClearingOrganizationPartyReference")
		public SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder setPredeterminedClearingOrganizationPartyReference(PartyReference predeterminedClearingOrganizationPartyReference) {
			this.predeterminedClearingOrganizationPartyReference = predeterminedClearingOrganizationPartyReference==null?null:predeterminedClearingOrganizationPartyReference.toBuilder();
			return this;
		}
		
		@Override
		public SwaptionPhysicalSettlement build() {
			return new SwaptionPhysicalSettlement.SwaptionPhysicalSettlementImpl(this);
		}
		
		@Override
		public SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder prune() {
			if (predeterminedClearingOrganizationPartyReference!=null && !predeterminedClearingOrganizationPartyReference.prune().hasData()) predeterminedClearingOrganizationPartyReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getClearedPhysicalSettlement()!=null) return true;
			if (getPredeterminedClearingOrganizationPartyReference()!=null && getPredeterminedClearingOrganizationPartyReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder o = (SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder) other;
			
			merger.mergeRosetta(getPredeterminedClearingOrganizationPartyReference(), o.getPredeterminedClearingOrganizationPartyReference(), this::setPredeterminedClearingOrganizationPartyReference);
			
			merger.mergeBasic(getClearedPhysicalSettlement(), o.getClearedPhysicalSettlement(), this::setClearedPhysicalSettlement);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SwaptionPhysicalSettlement _that = getType().cast(o);
		
			if (!Objects.equals(clearedPhysicalSettlement, _that.getClearedPhysicalSettlement())) return false;
			if (!Objects.equals(predeterminedClearingOrganizationPartyReference, _that.getPredeterminedClearingOrganizationPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (clearedPhysicalSettlement != null ? clearedPhysicalSettlement.hashCode() : 0);
			_result = 31 * _result + (predeterminedClearingOrganizationPartyReference != null ? predeterminedClearingOrganizationPartyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SwaptionPhysicalSettlementBuilder {" +
				"clearedPhysicalSettlement=" + this.clearedPhysicalSettlement + ", " +
				"predeterminedClearingOrganizationPartyReference=" + this.predeterminedClearingOrganizationPartyReference +
			'}';
		}
	}
}
