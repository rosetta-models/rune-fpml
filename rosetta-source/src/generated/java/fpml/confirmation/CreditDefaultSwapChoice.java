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
import fpml.confirmation.CashSettlementTerms;
import fpml.confirmation.CreditDefaultSwapChoice;
import fpml.confirmation.CreditDefaultSwapChoice.CreditDefaultSwapChoiceBuilder;
import fpml.confirmation.CreditDefaultSwapChoice.CreditDefaultSwapChoiceBuilderImpl;
import fpml.confirmation.CreditDefaultSwapChoice.CreditDefaultSwapChoiceImpl;
import fpml.confirmation.PhysicalSettlementTerms;
import fpml.confirmation.meta.CreditDefaultSwapChoiceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="CreditDefaultSwapChoice", builder=CreditDefaultSwapChoice.CreditDefaultSwapChoiceBuilderImpl.class, version="${project.version}")
public interface CreditDefaultSwapChoice extends RosettaModelObject {

	CreditDefaultSwapChoiceMeta metaData = new CreditDefaultSwapChoiceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * This element contains all the ISDA terms relevant to cash settlement for when cash settlement is applicable. ISDA 2003 Term: Cash Settlement
	 */
	CashSettlementTerms getCashSettlementTerms();
	/**
	 * This element contains all the ISDA terms relevant to physical settlement for when physical settlement is applicable. ISDA 2003 Term: Physical Settlement
	 */
	PhysicalSettlementTerms getPhysicalSettlementTerms();

	/*********************** Build Methods  ***********************/
	CreditDefaultSwapChoice build();
	
	CreditDefaultSwapChoice.CreditDefaultSwapChoiceBuilder toBuilder();
	
	static CreditDefaultSwapChoice.CreditDefaultSwapChoiceBuilder builder() {
		return new CreditDefaultSwapChoice.CreditDefaultSwapChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditDefaultSwapChoice> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CreditDefaultSwapChoice> getType() {
		return CreditDefaultSwapChoice.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("cashSettlementTerms"), processor, CashSettlementTerms.class, getCashSettlementTerms());
		processRosetta(path.newSubPath("physicalSettlementTerms"), processor, PhysicalSettlementTerms.class, getPhysicalSettlementTerms());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditDefaultSwapChoiceBuilder extends CreditDefaultSwapChoice, RosettaModelObjectBuilder {
		CashSettlementTerms.CashSettlementTermsBuilder getOrCreateCashSettlementTerms();
		CashSettlementTerms.CashSettlementTermsBuilder getCashSettlementTerms();
		PhysicalSettlementTerms.PhysicalSettlementTermsBuilder getOrCreatePhysicalSettlementTerms();
		PhysicalSettlementTerms.PhysicalSettlementTermsBuilder getPhysicalSettlementTerms();
		CreditDefaultSwapChoice.CreditDefaultSwapChoiceBuilder setCashSettlementTerms(CashSettlementTerms cashSettlementTerms);
		CreditDefaultSwapChoice.CreditDefaultSwapChoiceBuilder setPhysicalSettlementTerms(PhysicalSettlementTerms physicalSettlementTerms);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("cashSettlementTerms"), processor, CashSettlementTerms.CashSettlementTermsBuilder.class, getCashSettlementTerms());
			processRosetta(path.newSubPath("physicalSettlementTerms"), processor, PhysicalSettlementTerms.PhysicalSettlementTermsBuilder.class, getPhysicalSettlementTerms());
		}
		

		CreditDefaultSwapChoice.CreditDefaultSwapChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of CreditDefaultSwapChoice  ***********************/
	class CreditDefaultSwapChoiceImpl implements CreditDefaultSwapChoice {
		private final CashSettlementTerms cashSettlementTerms;
		private final PhysicalSettlementTerms physicalSettlementTerms;
		
		protected CreditDefaultSwapChoiceImpl(CreditDefaultSwapChoice.CreditDefaultSwapChoiceBuilder builder) {
			this.cashSettlementTerms = ofNullable(builder.getCashSettlementTerms()).map(f->f.build()).orElse(null);
			this.physicalSettlementTerms = ofNullable(builder.getPhysicalSettlementTerms()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("cashSettlementTerms")
		public CashSettlementTerms getCashSettlementTerms() {
			return cashSettlementTerms;
		}
		
		@Override
		@RosettaAttribute("physicalSettlementTerms")
		public PhysicalSettlementTerms getPhysicalSettlementTerms() {
			return physicalSettlementTerms;
		}
		
		@Override
		public CreditDefaultSwapChoice build() {
			return this;
		}
		
		@Override
		public CreditDefaultSwapChoice.CreditDefaultSwapChoiceBuilder toBuilder() {
			CreditDefaultSwapChoice.CreditDefaultSwapChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditDefaultSwapChoice.CreditDefaultSwapChoiceBuilder builder) {
			ofNullable(getCashSettlementTerms()).ifPresent(builder::setCashSettlementTerms);
			ofNullable(getPhysicalSettlementTerms()).ifPresent(builder::setPhysicalSettlementTerms);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditDefaultSwapChoice _that = getType().cast(o);
		
			if (!Objects.equals(cashSettlementTerms, _that.getCashSettlementTerms())) return false;
			if (!Objects.equals(physicalSettlementTerms, _that.getPhysicalSettlementTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cashSettlementTerms != null ? cashSettlementTerms.hashCode() : 0);
			_result = 31 * _result + (physicalSettlementTerms != null ? physicalSettlementTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditDefaultSwapChoice {" +
				"cashSettlementTerms=" + this.cashSettlementTerms + ", " +
				"physicalSettlementTerms=" + this.physicalSettlementTerms +
			'}';
		}
	}

	/*********************** Builder Implementation of CreditDefaultSwapChoice  ***********************/
	class CreditDefaultSwapChoiceBuilderImpl implements CreditDefaultSwapChoice.CreditDefaultSwapChoiceBuilder {
	
		protected CashSettlementTerms.CashSettlementTermsBuilder cashSettlementTerms;
		protected PhysicalSettlementTerms.PhysicalSettlementTermsBuilder physicalSettlementTerms;
	
		public CreditDefaultSwapChoiceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("cashSettlementTerms")
		public CashSettlementTerms.CashSettlementTermsBuilder getCashSettlementTerms() {
			return cashSettlementTerms;
		}
		
		@Override
		public CashSettlementTerms.CashSettlementTermsBuilder getOrCreateCashSettlementTerms() {
			CashSettlementTerms.CashSettlementTermsBuilder result;
			if (cashSettlementTerms!=null) {
				result = cashSettlementTerms;
			}
			else {
				result = cashSettlementTerms = CashSettlementTerms.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("physicalSettlementTerms")
		public PhysicalSettlementTerms.PhysicalSettlementTermsBuilder getPhysicalSettlementTerms() {
			return physicalSettlementTerms;
		}
		
		@Override
		public PhysicalSettlementTerms.PhysicalSettlementTermsBuilder getOrCreatePhysicalSettlementTerms() {
			PhysicalSettlementTerms.PhysicalSettlementTermsBuilder result;
			if (physicalSettlementTerms!=null) {
				result = physicalSettlementTerms;
			}
			else {
				result = physicalSettlementTerms = PhysicalSettlementTerms.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("cashSettlementTerms")
		public CreditDefaultSwapChoice.CreditDefaultSwapChoiceBuilder setCashSettlementTerms(CashSettlementTerms cashSettlementTerms) {
			this.cashSettlementTerms = cashSettlementTerms==null?null:cashSettlementTerms.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("physicalSettlementTerms")
		public CreditDefaultSwapChoice.CreditDefaultSwapChoiceBuilder setPhysicalSettlementTerms(PhysicalSettlementTerms physicalSettlementTerms) {
			this.physicalSettlementTerms = physicalSettlementTerms==null?null:physicalSettlementTerms.toBuilder();
			return this;
		}
		
		@Override
		public CreditDefaultSwapChoice build() {
			return new CreditDefaultSwapChoice.CreditDefaultSwapChoiceImpl(this);
		}
		
		@Override
		public CreditDefaultSwapChoice.CreditDefaultSwapChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditDefaultSwapChoice.CreditDefaultSwapChoiceBuilder prune() {
			if (cashSettlementTerms!=null && !cashSettlementTerms.prune().hasData()) cashSettlementTerms = null;
			if (physicalSettlementTerms!=null && !physicalSettlementTerms.prune().hasData()) physicalSettlementTerms = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCashSettlementTerms()!=null && getCashSettlementTerms().hasData()) return true;
			if (getPhysicalSettlementTerms()!=null && getPhysicalSettlementTerms().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditDefaultSwapChoice.CreditDefaultSwapChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CreditDefaultSwapChoice.CreditDefaultSwapChoiceBuilder o = (CreditDefaultSwapChoice.CreditDefaultSwapChoiceBuilder) other;
			
			merger.mergeRosetta(getCashSettlementTerms(), o.getCashSettlementTerms(), this::setCashSettlementTerms);
			merger.mergeRosetta(getPhysicalSettlementTerms(), o.getPhysicalSettlementTerms(), this::setPhysicalSettlementTerms);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditDefaultSwapChoice _that = getType().cast(o);
		
			if (!Objects.equals(cashSettlementTerms, _that.getCashSettlementTerms())) return false;
			if (!Objects.equals(physicalSettlementTerms, _that.getPhysicalSettlementTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cashSettlementTerms != null ? cashSettlementTerms.hashCode() : 0);
			_result = 31 * _result + (physicalSettlementTerms != null ? physicalSettlementTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditDefaultSwapChoiceBuilder {" +
				"cashSettlementTerms=" + this.cashSettlementTerms + ", " +
				"physicalSettlementTerms=" + this.physicalSettlementTerms +
			'}';
		}
	}
}
