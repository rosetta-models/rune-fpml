package fpml.confirmation;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.confirmation.CashSettlementReferenceBanks;
import fpml.confirmation.CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder;
import fpml.confirmation.CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilderImpl;
import fpml.confirmation.CashSettlementReferenceBanks.CashSettlementReferenceBanksImpl;
import fpml.confirmation.ReferenceBank;
import fpml.confirmation.meta.CashSettlementReferenceBanksMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A type defining the list of reference institutions polled for relevant rates or prices when determining the cash settlement amount for a product where cash settlement is applicable.
 * @version ${project.version}
 */
@RosettaDataType(value="CashSettlementReferenceBanks", builder=CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilderImpl.class, version="${project.version}")
public interface CashSettlementReferenceBanks extends RosettaModelObject {

	CashSettlementReferenceBanksMeta metaData = new CashSettlementReferenceBanksMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * An institution (party) identified by means of a coding scheme and an optional name.
	 */
	List<? extends ReferenceBank> getReferenceBank();
	String getId();

	/*********************** Build Methods  ***********************/
	CashSettlementReferenceBanks build();
	
	CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder toBuilder();
	
	static CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder builder() {
		return new CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CashSettlementReferenceBanks> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CashSettlementReferenceBanks> getType() {
		return CashSettlementReferenceBanks.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("referenceBank"), processor, ReferenceBank.class, getReferenceBank());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CashSettlementReferenceBanksBuilder extends CashSettlementReferenceBanks, RosettaModelObjectBuilder {
		ReferenceBank.ReferenceBankBuilder getOrCreateReferenceBank(int _index);
		List<? extends ReferenceBank.ReferenceBankBuilder> getReferenceBank();
		CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder addReferenceBank(ReferenceBank referenceBank0);
		CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder addReferenceBank(ReferenceBank referenceBank1, int _idx);
		CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder addReferenceBank(List<? extends ReferenceBank> referenceBank2);
		CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder setReferenceBank(List<? extends ReferenceBank> referenceBank3);
		CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("referenceBank"), processor, ReferenceBank.ReferenceBankBuilder.class, getReferenceBank());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder prune();
	}

	/*********************** Immutable Implementation of CashSettlementReferenceBanks  ***********************/
	class CashSettlementReferenceBanksImpl implements CashSettlementReferenceBanks {
		private final List<? extends ReferenceBank> referenceBank;
		private final String id;
		
		protected CashSettlementReferenceBanksImpl(CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder builder) {
			this.referenceBank = ofNullable(builder.getReferenceBank()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("referenceBank")
		public List<? extends ReferenceBank> getReferenceBank() {
			return referenceBank;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public CashSettlementReferenceBanks build() {
			return this;
		}
		
		@Override
		public CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder toBuilder() {
			CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder builder) {
			ofNullable(getReferenceBank()).ifPresent(builder::setReferenceBank);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CashSettlementReferenceBanks _that = getType().cast(o);
		
			if (!ListEquals.listEquals(referenceBank, _that.getReferenceBank())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (referenceBank != null ? referenceBank.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CashSettlementReferenceBanks {" +
				"referenceBank=" + this.referenceBank + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of CashSettlementReferenceBanks  ***********************/
	class CashSettlementReferenceBanksBuilderImpl implements CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder {
	
		protected List<ReferenceBank.ReferenceBankBuilder> referenceBank = new ArrayList<>();
		protected String id;
	
		public CashSettlementReferenceBanksBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("referenceBank")
		public List<? extends ReferenceBank.ReferenceBankBuilder> getReferenceBank() {
			return referenceBank;
		}
		
		public ReferenceBank.ReferenceBankBuilder getOrCreateReferenceBank(int _index) {
		
			if (referenceBank==null) {
				this.referenceBank = new ArrayList<>();
			}
			ReferenceBank.ReferenceBankBuilder result;
			return getIndex(referenceBank, _index, () -> {
						ReferenceBank.ReferenceBankBuilder newReferenceBank = ReferenceBank.builder();
						return newReferenceBank;
					});
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder addReferenceBank(ReferenceBank referenceBank) {
			if (referenceBank!=null) this.referenceBank.add(referenceBank.toBuilder());
			return this;
		}
		
		@Override
		public CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder addReferenceBank(ReferenceBank referenceBank, int _idx) {
			getIndex(this.referenceBank, _idx, () -> referenceBank.toBuilder());
			return this;
		}
		@Override 
		public CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder addReferenceBank(List<? extends ReferenceBank> referenceBanks) {
			if (referenceBanks != null) {
				for (ReferenceBank toAdd : referenceBanks) {
					this.referenceBank.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("referenceBank")
		public CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder setReferenceBank(List<? extends ReferenceBank> referenceBanks) {
			if (referenceBanks == null)  {
				this.referenceBank = new ArrayList<>();
			}
			else {
				this.referenceBank = referenceBanks.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("id")
		public CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public CashSettlementReferenceBanks build() {
			return new CashSettlementReferenceBanks.CashSettlementReferenceBanksImpl(this);
		}
		
		@Override
		public CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder prune() {
			referenceBank = referenceBank.stream().filter(b->b!=null).<ReferenceBank.ReferenceBankBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getReferenceBank()!=null && getReferenceBank().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder o = (CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder) other;
			
			merger.mergeRosetta(getReferenceBank(), o.getReferenceBank(), this::getOrCreateReferenceBank);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CashSettlementReferenceBanks _that = getType().cast(o);
		
			if (!ListEquals.listEquals(referenceBank, _that.getReferenceBank())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (referenceBank != null ? referenceBank.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CashSettlementReferenceBanksBuilder {" +
				"referenceBank=" + this.referenceBank + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
