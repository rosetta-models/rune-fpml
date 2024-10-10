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
import fpml.confirmation.ConstituentWeight;
import fpml.confirmation.ProtectionTermsReference;
import fpml.confirmation.ReferencePair;
import fpml.confirmation.ReferencePoolItem;
import fpml.confirmation.ReferencePoolItem.ReferencePoolItemBuilder;
import fpml.confirmation.ReferencePoolItem.ReferencePoolItemBuilderImpl;
import fpml.confirmation.ReferencePoolItem.ReferencePoolItemImpl;
import fpml.confirmation.SettlementTermsReference;
import fpml.confirmation.meta.ReferencePoolItemMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * This type contains all the constituent weight and reference information.
 * @version ${project.version}
 */
@RosettaDataType(value="ReferencePoolItem", builder=ReferencePoolItem.ReferencePoolItemBuilderImpl.class, version="${project.version}")
public interface ReferencePoolItem extends RosettaModelObject {

	ReferencePoolItemMeta metaData = new ReferencePoolItemMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Describes the weight of each of the constituents within the basket. If not provided, it is assumed to be equal weighted.
	 */
	ConstituentWeight getConstituentWeight();
	ReferencePair getReferencePair();
	/**
	 * Reference to the documentation terms applicable to this item.
	 */
	ProtectionTermsReference getProtectionTermsReference();
	/**
	 * Reference to the settlement terms applicable to this item.
	 */
	SettlementTermsReference getSettlementTermsReference();

	/*********************** Build Methods  ***********************/
	ReferencePoolItem build();
	
	ReferencePoolItem.ReferencePoolItemBuilder toBuilder();
	
	static ReferencePoolItem.ReferencePoolItemBuilder builder() {
		return new ReferencePoolItem.ReferencePoolItemBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReferencePoolItem> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ReferencePoolItem> getType() {
		return ReferencePoolItem.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("constituentWeight"), processor, ConstituentWeight.class, getConstituentWeight());
		processRosetta(path.newSubPath("referencePair"), processor, ReferencePair.class, getReferencePair());
		processRosetta(path.newSubPath("protectionTermsReference"), processor, ProtectionTermsReference.class, getProtectionTermsReference());
		processRosetta(path.newSubPath("settlementTermsReference"), processor, SettlementTermsReference.class, getSettlementTermsReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReferencePoolItemBuilder extends ReferencePoolItem, RosettaModelObjectBuilder {
		ConstituentWeight.ConstituentWeightBuilder getOrCreateConstituentWeight();
		ConstituentWeight.ConstituentWeightBuilder getConstituentWeight();
		ReferencePair.ReferencePairBuilder getOrCreateReferencePair();
		ReferencePair.ReferencePairBuilder getReferencePair();
		ProtectionTermsReference.ProtectionTermsReferenceBuilder getOrCreateProtectionTermsReference();
		ProtectionTermsReference.ProtectionTermsReferenceBuilder getProtectionTermsReference();
		SettlementTermsReference.SettlementTermsReferenceBuilder getOrCreateSettlementTermsReference();
		SettlementTermsReference.SettlementTermsReferenceBuilder getSettlementTermsReference();
		ReferencePoolItem.ReferencePoolItemBuilder setConstituentWeight(ConstituentWeight constituentWeight);
		ReferencePoolItem.ReferencePoolItemBuilder setReferencePair(ReferencePair referencePair);
		ReferencePoolItem.ReferencePoolItemBuilder setProtectionTermsReference(ProtectionTermsReference protectionTermsReference);
		ReferencePoolItem.ReferencePoolItemBuilder setSettlementTermsReference(SettlementTermsReference settlementTermsReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("constituentWeight"), processor, ConstituentWeight.ConstituentWeightBuilder.class, getConstituentWeight());
			processRosetta(path.newSubPath("referencePair"), processor, ReferencePair.ReferencePairBuilder.class, getReferencePair());
			processRosetta(path.newSubPath("protectionTermsReference"), processor, ProtectionTermsReference.ProtectionTermsReferenceBuilder.class, getProtectionTermsReference());
			processRosetta(path.newSubPath("settlementTermsReference"), processor, SettlementTermsReference.SettlementTermsReferenceBuilder.class, getSettlementTermsReference());
		}
		

		ReferencePoolItem.ReferencePoolItemBuilder prune();
	}

	/*********************** Immutable Implementation of ReferencePoolItem  ***********************/
	class ReferencePoolItemImpl implements ReferencePoolItem {
		private final ConstituentWeight constituentWeight;
		private final ReferencePair referencePair;
		private final ProtectionTermsReference protectionTermsReference;
		private final SettlementTermsReference settlementTermsReference;
		
		protected ReferencePoolItemImpl(ReferencePoolItem.ReferencePoolItemBuilder builder) {
			this.constituentWeight = ofNullable(builder.getConstituentWeight()).map(f->f.build()).orElse(null);
			this.referencePair = ofNullable(builder.getReferencePair()).map(f->f.build()).orElse(null);
			this.protectionTermsReference = ofNullable(builder.getProtectionTermsReference()).map(f->f.build()).orElse(null);
			this.settlementTermsReference = ofNullable(builder.getSettlementTermsReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("constituentWeight")
		public ConstituentWeight getConstituentWeight() {
			return constituentWeight;
		}
		
		@Override
		@RosettaAttribute("referencePair")
		public ReferencePair getReferencePair() {
			return referencePair;
		}
		
		@Override
		@RosettaAttribute("protectionTermsReference")
		public ProtectionTermsReference getProtectionTermsReference() {
			return protectionTermsReference;
		}
		
		@Override
		@RosettaAttribute("settlementTermsReference")
		public SettlementTermsReference getSettlementTermsReference() {
			return settlementTermsReference;
		}
		
		@Override
		public ReferencePoolItem build() {
			return this;
		}
		
		@Override
		public ReferencePoolItem.ReferencePoolItemBuilder toBuilder() {
			ReferencePoolItem.ReferencePoolItemBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReferencePoolItem.ReferencePoolItemBuilder builder) {
			ofNullable(getConstituentWeight()).ifPresent(builder::setConstituentWeight);
			ofNullable(getReferencePair()).ifPresent(builder::setReferencePair);
			ofNullable(getProtectionTermsReference()).ifPresent(builder::setProtectionTermsReference);
			ofNullable(getSettlementTermsReference()).ifPresent(builder::setSettlementTermsReference);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferencePoolItem _that = getType().cast(o);
		
			if (!Objects.equals(constituentWeight, _that.getConstituentWeight())) return false;
			if (!Objects.equals(referencePair, _that.getReferencePair())) return false;
			if (!Objects.equals(protectionTermsReference, _that.getProtectionTermsReference())) return false;
			if (!Objects.equals(settlementTermsReference, _that.getSettlementTermsReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (constituentWeight != null ? constituentWeight.hashCode() : 0);
			_result = 31 * _result + (referencePair != null ? referencePair.hashCode() : 0);
			_result = 31 * _result + (protectionTermsReference != null ? protectionTermsReference.hashCode() : 0);
			_result = 31 * _result + (settlementTermsReference != null ? settlementTermsReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReferencePoolItem {" +
				"constituentWeight=" + this.constituentWeight + ", " +
				"referencePair=" + this.referencePair + ", " +
				"protectionTermsReference=" + this.protectionTermsReference + ", " +
				"settlementTermsReference=" + this.settlementTermsReference +
			'}';
		}
	}

	/*********************** Builder Implementation of ReferencePoolItem  ***********************/
	class ReferencePoolItemBuilderImpl implements ReferencePoolItem.ReferencePoolItemBuilder {
	
		protected ConstituentWeight.ConstituentWeightBuilder constituentWeight;
		protected ReferencePair.ReferencePairBuilder referencePair;
		protected ProtectionTermsReference.ProtectionTermsReferenceBuilder protectionTermsReference;
		protected SettlementTermsReference.SettlementTermsReferenceBuilder settlementTermsReference;
	
		public ReferencePoolItemBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("constituentWeight")
		public ConstituentWeight.ConstituentWeightBuilder getConstituentWeight() {
			return constituentWeight;
		}
		
		@Override
		public ConstituentWeight.ConstituentWeightBuilder getOrCreateConstituentWeight() {
			ConstituentWeight.ConstituentWeightBuilder result;
			if (constituentWeight!=null) {
				result = constituentWeight;
			}
			else {
				result = constituentWeight = ConstituentWeight.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("referencePair")
		public ReferencePair.ReferencePairBuilder getReferencePair() {
			return referencePair;
		}
		
		@Override
		public ReferencePair.ReferencePairBuilder getOrCreateReferencePair() {
			ReferencePair.ReferencePairBuilder result;
			if (referencePair!=null) {
				result = referencePair;
			}
			else {
				result = referencePair = ReferencePair.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("protectionTermsReference")
		public ProtectionTermsReference.ProtectionTermsReferenceBuilder getProtectionTermsReference() {
			return protectionTermsReference;
		}
		
		@Override
		public ProtectionTermsReference.ProtectionTermsReferenceBuilder getOrCreateProtectionTermsReference() {
			ProtectionTermsReference.ProtectionTermsReferenceBuilder result;
			if (protectionTermsReference!=null) {
				result = protectionTermsReference;
			}
			else {
				result = protectionTermsReference = ProtectionTermsReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementTermsReference")
		public SettlementTermsReference.SettlementTermsReferenceBuilder getSettlementTermsReference() {
			return settlementTermsReference;
		}
		
		@Override
		public SettlementTermsReference.SettlementTermsReferenceBuilder getOrCreateSettlementTermsReference() {
			SettlementTermsReference.SettlementTermsReferenceBuilder result;
			if (settlementTermsReference!=null) {
				result = settlementTermsReference;
			}
			else {
				result = settlementTermsReference = SettlementTermsReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("constituentWeight")
		public ReferencePoolItem.ReferencePoolItemBuilder setConstituentWeight(ConstituentWeight constituentWeight) {
			this.constituentWeight = constituentWeight==null?null:constituentWeight.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("referencePair")
		public ReferencePoolItem.ReferencePoolItemBuilder setReferencePair(ReferencePair referencePair) {
			this.referencePair = referencePair==null?null:referencePair.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("protectionTermsReference")
		public ReferencePoolItem.ReferencePoolItemBuilder setProtectionTermsReference(ProtectionTermsReference protectionTermsReference) {
			this.protectionTermsReference = protectionTermsReference==null?null:protectionTermsReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("settlementTermsReference")
		public ReferencePoolItem.ReferencePoolItemBuilder setSettlementTermsReference(SettlementTermsReference settlementTermsReference) {
			this.settlementTermsReference = settlementTermsReference==null?null:settlementTermsReference.toBuilder();
			return this;
		}
		
		@Override
		public ReferencePoolItem build() {
			return new ReferencePoolItem.ReferencePoolItemImpl(this);
		}
		
		@Override
		public ReferencePoolItem.ReferencePoolItemBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferencePoolItem.ReferencePoolItemBuilder prune() {
			if (constituentWeight!=null && !constituentWeight.prune().hasData()) constituentWeight = null;
			if (referencePair!=null && !referencePair.prune().hasData()) referencePair = null;
			if (protectionTermsReference!=null && !protectionTermsReference.prune().hasData()) protectionTermsReference = null;
			if (settlementTermsReference!=null && !settlementTermsReference.prune().hasData()) settlementTermsReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getConstituentWeight()!=null && getConstituentWeight().hasData()) return true;
			if (getReferencePair()!=null && getReferencePair().hasData()) return true;
			if (getProtectionTermsReference()!=null && getProtectionTermsReference().hasData()) return true;
			if (getSettlementTermsReference()!=null && getSettlementTermsReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferencePoolItem.ReferencePoolItemBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReferencePoolItem.ReferencePoolItemBuilder o = (ReferencePoolItem.ReferencePoolItemBuilder) other;
			
			merger.mergeRosetta(getConstituentWeight(), o.getConstituentWeight(), this::setConstituentWeight);
			merger.mergeRosetta(getReferencePair(), o.getReferencePair(), this::setReferencePair);
			merger.mergeRosetta(getProtectionTermsReference(), o.getProtectionTermsReference(), this::setProtectionTermsReference);
			merger.mergeRosetta(getSettlementTermsReference(), o.getSettlementTermsReference(), this::setSettlementTermsReference);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferencePoolItem _that = getType().cast(o);
		
			if (!Objects.equals(constituentWeight, _that.getConstituentWeight())) return false;
			if (!Objects.equals(referencePair, _that.getReferencePair())) return false;
			if (!Objects.equals(protectionTermsReference, _that.getProtectionTermsReference())) return false;
			if (!Objects.equals(settlementTermsReference, _that.getSettlementTermsReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (constituentWeight != null ? constituentWeight.hashCode() : 0);
			_result = 31 * _result + (referencePair != null ? referencePair.hashCode() : 0);
			_result = 31 * _result + (protectionTermsReference != null ? protectionTermsReference.hashCode() : 0);
			_result = 31 * _result + (settlementTermsReference != null ? settlementTermsReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReferencePoolItemBuilder {" +
				"constituentWeight=" + this.constituentWeight + ", " +
				"referencePair=" + this.referencePair + ", " +
				"protectionTermsReference=" + this.protectionTermsReference + ", " +
				"settlementTermsReference=" + this.settlementTermsReference +
			'}';
		}
	}
}
