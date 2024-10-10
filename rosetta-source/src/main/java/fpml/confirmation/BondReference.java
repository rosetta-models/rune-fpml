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
import fpml.confirmation.Bond;
import fpml.confirmation.BondReference;
import fpml.confirmation.BondReference.BondReferenceBuilder;
import fpml.confirmation.BondReference.BondReferenceBuilderImpl;
import fpml.confirmation.BondReference.BondReferenceImpl;
import fpml.confirmation.meta.BondReferenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type including a reference to a bond to support the representation of an asset swap or Condition Precedent Bond.
 * @version ${project.version}
 */
@RosettaDataType(value="BondReference", builder=BondReference.BondReferenceBuilderImpl.class, version="${project.version}")
public interface BondReference extends RosettaModelObject {

	BondReferenceMeta metaData = new BondReferenceMeta();

	/*********************** Getter Methods  ***********************/
	Bond getBond();
	/**
	 * To indicate whether the Condition Precedent Bond is applicable. The swap contract is only valid if the bond is issued and if there is any dispute over the terms of fixed stream then the bond terms would be used.
	 */
	Boolean getConditionPrecedentBond();
	/**
	 * To indicate whether the Discrepancy Clause is applicable.
	 */
	Boolean getDiscrepancyClause();

	/*********************** Build Methods  ***********************/
	BondReference build();
	
	BondReference.BondReferenceBuilder toBuilder();
	
	static BondReference.BondReferenceBuilder builder() {
		return new BondReference.BondReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BondReference> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends BondReference> getType() {
		return BondReference.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("bond"), processor, Bond.class, getBond());
		processor.processBasic(path.newSubPath("conditionPrecedentBond"), Boolean.class, getConditionPrecedentBond(), this);
		processor.processBasic(path.newSubPath("discrepancyClause"), Boolean.class, getDiscrepancyClause(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface BondReferenceBuilder extends BondReference, RosettaModelObjectBuilder {
		Bond.BondBuilder getOrCreateBond();
		Bond.BondBuilder getBond();
		BondReference.BondReferenceBuilder setBond(Bond bond);
		BondReference.BondReferenceBuilder setConditionPrecedentBond(Boolean conditionPrecedentBond);
		BondReference.BondReferenceBuilder setDiscrepancyClause(Boolean discrepancyClause);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("bond"), processor, Bond.BondBuilder.class, getBond());
			processor.processBasic(path.newSubPath("conditionPrecedentBond"), Boolean.class, getConditionPrecedentBond(), this);
			processor.processBasic(path.newSubPath("discrepancyClause"), Boolean.class, getDiscrepancyClause(), this);
		}
		

		BondReference.BondReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of BondReference  ***********************/
	class BondReferenceImpl implements BondReference {
		private final Bond bond;
		private final Boolean conditionPrecedentBond;
		private final Boolean discrepancyClause;
		
		protected BondReferenceImpl(BondReference.BondReferenceBuilder builder) {
			this.bond = ofNullable(builder.getBond()).map(f->f.build()).orElse(null);
			this.conditionPrecedentBond = builder.getConditionPrecedentBond();
			this.discrepancyClause = builder.getDiscrepancyClause();
		}
		
		@Override
		@RosettaAttribute("bond")
		public Bond getBond() {
			return bond;
		}
		
		@Override
		@RosettaAttribute("conditionPrecedentBond")
		public Boolean getConditionPrecedentBond() {
			return conditionPrecedentBond;
		}
		
		@Override
		@RosettaAttribute("discrepancyClause")
		public Boolean getDiscrepancyClause() {
			return discrepancyClause;
		}
		
		@Override
		public BondReference build() {
			return this;
		}
		
		@Override
		public BondReference.BondReferenceBuilder toBuilder() {
			BondReference.BondReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BondReference.BondReferenceBuilder builder) {
			ofNullable(getBond()).ifPresent(builder::setBond);
			ofNullable(getConditionPrecedentBond()).ifPresent(builder::setConditionPrecedentBond);
			ofNullable(getDiscrepancyClause()).ifPresent(builder::setDiscrepancyClause);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BondReference _that = getType().cast(o);
		
			if (!Objects.equals(bond, _that.getBond())) return false;
			if (!Objects.equals(conditionPrecedentBond, _that.getConditionPrecedentBond())) return false;
			if (!Objects.equals(discrepancyClause, _that.getDiscrepancyClause())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (bond != null ? bond.hashCode() : 0);
			_result = 31 * _result + (conditionPrecedentBond != null ? conditionPrecedentBond.hashCode() : 0);
			_result = 31 * _result + (discrepancyClause != null ? discrepancyClause.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BondReference {" +
				"bond=" + this.bond + ", " +
				"conditionPrecedentBond=" + this.conditionPrecedentBond + ", " +
				"discrepancyClause=" + this.discrepancyClause +
			'}';
		}
	}

	/*********************** Builder Implementation of BondReference  ***********************/
	class BondReferenceBuilderImpl implements BondReference.BondReferenceBuilder {
	
		protected Bond.BondBuilder bond;
		protected Boolean conditionPrecedentBond;
		protected Boolean discrepancyClause;
	
		public BondReferenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("bond")
		public Bond.BondBuilder getBond() {
			return bond;
		}
		
		@Override
		public Bond.BondBuilder getOrCreateBond() {
			Bond.BondBuilder result;
			if (bond!=null) {
				result = bond;
			}
			else {
				result = bond = Bond.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("conditionPrecedentBond")
		public Boolean getConditionPrecedentBond() {
			return conditionPrecedentBond;
		}
		
		@Override
		@RosettaAttribute("discrepancyClause")
		public Boolean getDiscrepancyClause() {
			return discrepancyClause;
		}
		
		@Override
		@RosettaAttribute("bond")
		public BondReference.BondReferenceBuilder setBond(Bond bond) {
			this.bond = bond==null?null:bond.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("conditionPrecedentBond")
		public BondReference.BondReferenceBuilder setConditionPrecedentBond(Boolean conditionPrecedentBond) {
			this.conditionPrecedentBond = conditionPrecedentBond==null?null:conditionPrecedentBond;
			return this;
		}
		@Override
		@RosettaAttribute("discrepancyClause")
		public BondReference.BondReferenceBuilder setDiscrepancyClause(Boolean discrepancyClause) {
			this.discrepancyClause = discrepancyClause==null?null:discrepancyClause;
			return this;
		}
		
		@Override
		public BondReference build() {
			return new BondReference.BondReferenceImpl(this);
		}
		
		@Override
		public BondReference.BondReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BondReference.BondReferenceBuilder prune() {
			if (bond!=null && !bond.prune().hasData()) bond = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBond()!=null && getBond().hasData()) return true;
			if (getConditionPrecedentBond()!=null) return true;
			if (getDiscrepancyClause()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BondReference.BondReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BondReference.BondReferenceBuilder o = (BondReference.BondReferenceBuilder) other;
			
			merger.mergeRosetta(getBond(), o.getBond(), this::setBond);
			
			merger.mergeBasic(getConditionPrecedentBond(), o.getConditionPrecedentBond(), this::setConditionPrecedentBond);
			merger.mergeBasic(getDiscrepancyClause(), o.getDiscrepancyClause(), this::setDiscrepancyClause);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BondReference _that = getType().cast(o);
		
			if (!Objects.equals(bond, _that.getBond())) return false;
			if (!Objects.equals(conditionPrecedentBond, _that.getConditionPrecedentBond())) return false;
			if (!Objects.equals(discrepancyClause, _that.getDiscrepancyClause())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (bond != null ? bond.hashCode() : 0);
			_result = 31 * _result + (conditionPrecedentBond != null ? conditionPrecedentBond.hashCode() : 0);
			_result = 31 * _result + (discrepancyClause != null ? discrepancyClause.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BondReferenceBuilder {" +
				"bond=" + this.bond + ", " +
				"conditionPrecedentBond=" + this.conditionPrecedentBond + ", " +
				"discrepancyClause=" + this.discrepancyClause +
			'}';
		}
	}
}
