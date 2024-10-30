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
import fpml.confirmation.AccrualOptionChangeNotificationSequence0;
import fpml.confirmation.AccrualOptionChangeNotificationSequence0.AccrualOptionChangeNotificationSequence0Builder;
import fpml.confirmation.AccrualOptionChangeNotificationSequence0.AccrualOptionChangeNotificationSequence0BuilderImpl;
import fpml.confirmation.AccrualOptionChangeNotificationSequence0.AccrualOptionChangeNotificationSequence0Impl;
import fpml.confirmation.FixedRateOptionChange;
import fpml.confirmation.FloatingRateOptionChange;
import fpml.confirmation.LoanContract;
import fpml.confirmation.meta.AccrualOptionChangeNotificationSequence0Meta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="AccrualOptionChangeNotificationSequence0", builder=AccrualOptionChangeNotificationSequence0.AccrualOptionChangeNotificationSequence0BuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface AccrualOptionChangeNotificationSequence0 extends RosettaModelObject {

	AccrualOptionChangeNotificationSequence0Meta metaData = new AccrualOptionChangeNotificationSequence0Meta();

	/*********************** Getter Methods  ***********************/
	FixedRateOptionChange getFixedRateOptionChange();
	FloatingRateOptionChange getFloatingRateOptionChange();
	List<? extends LoanContract> getContract();

	/*********************** Build Methods  ***********************/
	AccrualOptionChangeNotificationSequence0 build();
	
	AccrualOptionChangeNotificationSequence0.AccrualOptionChangeNotificationSequence0Builder toBuilder();
	
	static AccrualOptionChangeNotificationSequence0.AccrualOptionChangeNotificationSequence0Builder builder() {
		return new AccrualOptionChangeNotificationSequence0.AccrualOptionChangeNotificationSequence0BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AccrualOptionChangeNotificationSequence0> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AccrualOptionChangeNotificationSequence0> getType() {
		return AccrualOptionChangeNotificationSequence0.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("fixedRateOptionChange"), processor, FixedRateOptionChange.class, getFixedRateOptionChange());
		processRosetta(path.newSubPath("floatingRateOptionChange"), processor, FloatingRateOptionChange.class, getFloatingRateOptionChange());
		processRosetta(path.newSubPath("contract"), processor, LoanContract.class, getContract());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AccrualOptionChangeNotificationSequence0Builder extends AccrualOptionChangeNotificationSequence0, RosettaModelObjectBuilder {
		FixedRateOptionChange.FixedRateOptionChangeBuilder getOrCreateFixedRateOptionChange();
		FixedRateOptionChange.FixedRateOptionChangeBuilder getFixedRateOptionChange();
		FloatingRateOptionChange.FloatingRateOptionChangeBuilder getOrCreateFloatingRateOptionChange();
		FloatingRateOptionChange.FloatingRateOptionChangeBuilder getFloatingRateOptionChange();
		LoanContract.LoanContractBuilder getOrCreateContract(int _index);
		List<? extends LoanContract.LoanContractBuilder> getContract();
		AccrualOptionChangeNotificationSequence0.AccrualOptionChangeNotificationSequence0Builder setFixedRateOptionChange(FixedRateOptionChange fixedRateOptionChange);
		AccrualOptionChangeNotificationSequence0.AccrualOptionChangeNotificationSequence0Builder setFloatingRateOptionChange(FloatingRateOptionChange floatingRateOptionChange);
		AccrualOptionChangeNotificationSequence0.AccrualOptionChangeNotificationSequence0Builder addContract(LoanContract contract0);
		AccrualOptionChangeNotificationSequence0.AccrualOptionChangeNotificationSequence0Builder addContract(LoanContract contract1, int _idx);
		AccrualOptionChangeNotificationSequence0.AccrualOptionChangeNotificationSequence0Builder addContract(List<? extends LoanContract> contract2);
		AccrualOptionChangeNotificationSequence0.AccrualOptionChangeNotificationSequence0Builder setContract(List<? extends LoanContract> contract3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("fixedRateOptionChange"), processor, FixedRateOptionChange.FixedRateOptionChangeBuilder.class, getFixedRateOptionChange());
			processRosetta(path.newSubPath("floatingRateOptionChange"), processor, FloatingRateOptionChange.FloatingRateOptionChangeBuilder.class, getFloatingRateOptionChange());
			processRosetta(path.newSubPath("contract"), processor, LoanContract.LoanContractBuilder.class, getContract());
		}
		

		AccrualOptionChangeNotificationSequence0.AccrualOptionChangeNotificationSequence0Builder prune();
	}

	/*********************** Immutable Implementation of AccrualOptionChangeNotificationSequence0  ***********************/
	class AccrualOptionChangeNotificationSequence0Impl implements AccrualOptionChangeNotificationSequence0 {
		private final FixedRateOptionChange fixedRateOptionChange;
		private final FloatingRateOptionChange floatingRateOptionChange;
		private final List<? extends LoanContract> contract;
		
		protected AccrualOptionChangeNotificationSequence0Impl(AccrualOptionChangeNotificationSequence0.AccrualOptionChangeNotificationSequence0Builder builder) {
			this.fixedRateOptionChange = ofNullable(builder.getFixedRateOptionChange()).map(f->f.build()).orElse(null);
			this.floatingRateOptionChange = ofNullable(builder.getFloatingRateOptionChange()).map(f->f.build()).orElse(null);
			this.contract = ofNullable(builder.getContract()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("fixedRateOptionChange")
		public FixedRateOptionChange getFixedRateOptionChange() {
			return fixedRateOptionChange;
		}
		
		@Override
		@RosettaAttribute("floatingRateOptionChange")
		public FloatingRateOptionChange getFloatingRateOptionChange() {
			return floatingRateOptionChange;
		}
		
		@Override
		@RosettaAttribute("contract")
		public List<? extends LoanContract> getContract() {
			return contract;
		}
		
		@Override
		public AccrualOptionChangeNotificationSequence0 build() {
			return this;
		}
		
		@Override
		public AccrualOptionChangeNotificationSequence0.AccrualOptionChangeNotificationSequence0Builder toBuilder() {
			AccrualOptionChangeNotificationSequence0.AccrualOptionChangeNotificationSequence0Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AccrualOptionChangeNotificationSequence0.AccrualOptionChangeNotificationSequence0Builder builder) {
			ofNullable(getFixedRateOptionChange()).ifPresent(builder::setFixedRateOptionChange);
			ofNullable(getFloatingRateOptionChange()).ifPresent(builder::setFloatingRateOptionChange);
			ofNullable(getContract()).ifPresent(builder::setContract);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AccrualOptionChangeNotificationSequence0 _that = getType().cast(o);
		
			if (!Objects.equals(fixedRateOptionChange, _that.getFixedRateOptionChange())) return false;
			if (!Objects.equals(floatingRateOptionChange, _that.getFloatingRateOptionChange())) return false;
			if (!ListEquals.listEquals(contract, _that.getContract())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fixedRateOptionChange != null ? fixedRateOptionChange.hashCode() : 0);
			_result = 31 * _result + (floatingRateOptionChange != null ? floatingRateOptionChange.hashCode() : 0);
			_result = 31 * _result + (contract != null ? contract.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccrualOptionChangeNotificationSequence0 {" +
				"fixedRateOptionChange=" + this.fixedRateOptionChange + ", " +
				"floatingRateOptionChange=" + this.floatingRateOptionChange + ", " +
				"contract=" + this.contract +
			'}';
		}
	}

	/*********************** Builder Implementation of AccrualOptionChangeNotificationSequence0  ***********************/
	class AccrualOptionChangeNotificationSequence0BuilderImpl implements AccrualOptionChangeNotificationSequence0.AccrualOptionChangeNotificationSequence0Builder {
	
		protected FixedRateOptionChange.FixedRateOptionChangeBuilder fixedRateOptionChange;
		protected FloatingRateOptionChange.FloatingRateOptionChangeBuilder floatingRateOptionChange;
		protected List<LoanContract.LoanContractBuilder> contract = new ArrayList<>();
	
		public AccrualOptionChangeNotificationSequence0BuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("fixedRateOptionChange")
		public FixedRateOptionChange.FixedRateOptionChangeBuilder getFixedRateOptionChange() {
			return fixedRateOptionChange;
		}
		
		@Override
		public FixedRateOptionChange.FixedRateOptionChangeBuilder getOrCreateFixedRateOptionChange() {
			FixedRateOptionChange.FixedRateOptionChangeBuilder result;
			if (fixedRateOptionChange!=null) {
				result = fixedRateOptionChange;
			}
			else {
				result = fixedRateOptionChange = FixedRateOptionChange.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("floatingRateOptionChange")
		public FloatingRateOptionChange.FloatingRateOptionChangeBuilder getFloatingRateOptionChange() {
			return floatingRateOptionChange;
		}
		
		@Override
		public FloatingRateOptionChange.FloatingRateOptionChangeBuilder getOrCreateFloatingRateOptionChange() {
			FloatingRateOptionChange.FloatingRateOptionChangeBuilder result;
			if (floatingRateOptionChange!=null) {
				result = floatingRateOptionChange;
			}
			else {
				result = floatingRateOptionChange = FloatingRateOptionChange.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("contract")
		public List<? extends LoanContract.LoanContractBuilder> getContract() {
			return contract;
		}
		
		@Override
		public LoanContract.LoanContractBuilder getOrCreateContract(int _index) {
		
			if (contract==null) {
				this.contract = new ArrayList<>();
			}
			LoanContract.LoanContractBuilder result;
			return getIndex(contract, _index, () -> {
						LoanContract.LoanContractBuilder newContract = LoanContract.builder();
						return newContract;
					});
		}
		
		@Override
		@RosettaAttribute("fixedRateOptionChange")
		public AccrualOptionChangeNotificationSequence0.AccrualOptionChangeNotificationSequence0Builder setFixedRateOptionChange(FixedRateOptionChange fixedRateOptionChange) {
			this.fixedRateOptionChange = fixedRateOptionChange==null?null:fixedRateOptionChange.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("floatingRateOptionChange")
		public AccrualOptionChangeNotificationSequence0.AccrualOptionChangeNotificationSequence0Builder setFloatingRateOptionChange(FloatingRateOptionChange floatingRateOptionChange) {
			this.floatingRateOptionChange = floatingRateOptionChange==null?null:floatingRateOptionChange.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("contract")
		public AccrualOptionChangeNotificationSequence0.AccrualOptionChangeNotificationSequence0Builder addContract(LoanContract contract) {
			if (contract!=null) this.contract.add(contract.toBuilder());
			return this;
		}
		
		@Override
		public AccrualOptionChangeNotificationSequence0.AccrualOptionChangeNotificationSequence0Builder addContract(LoanContract contract, int _idx) {
			getIndex(this.contract, _idx, () -> contract.toBuilder());
			return this;
		}
		@Override 
		public AccrualOptionChangeNotificationSequence0.AccrualOptionChangeNotificationSequence0Builder addContract(List<? extends LoanContract> contracts) {
			if (contracts != null) {
				for (LoanContract toAdd : contracts) {
					this.contract.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public AccrualOptionChangeNotificationSequence0.AccrualOptionChangeNotificationSequence0Builder setContract(List<? extends LoanContract> contracts) {
			if (contracts == null)  {
				this.contract = new ArrayList<>();
			}
			else {
				this.contract = contracts.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public AccrualOptionChangeNotificationSequence0 build() {
			return new AccrualOptionChangeNotificationSequence0.AccrualOptionChangeNotificationSequence0Impl(this);
		}
		
		@Override
		public AccrualOptionChangeNotificationSequence0.AccrualOptionChangeNotificationSequence0Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccrualOptionChangeNotificationSequence0.AccrualOptionChangeNotificationSequence0Builder prune() {
			if (fixedRateOptionChange!=null && !fixedRateOptionChange.prune().hasData()) fixedRateOptionChange = null;
			if (floatingRateOptionChange!=null && !floatingRateOptionChange.prune().hasData()) floatingRateOptionChange = null;
			contract = contract.stream().filter(b->b!=null).<LoanContract.LoanContractBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFixedRateOptionChange()!=null && getFixedRateOptionChange().hasData()) return true;
			if (getFloatingRateOptionChange()!=null && getFloatingRateOptionChange().hasData()) return true;
			if (getContract()!=null && getContract().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccrualOptionChangeNotificationSequence0.AccrualOptionChangeNotificationSequence0Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AccrualOptionChangeNotificationSequence0.AccrualOptionChangeNotificationSequence0Builder o = (AccrualOptionChangeNotificationSequence0.AccrualOptionChangeNotificationSequence0Builder) other;
			
			merger.mergeRosetta(getFixedRateOptionChange(), o.getFixedRateOptionChange(), this::setFixedRateOptionChange);
			merger.mergeRosetta(getFloatingRateOptionChange(), o.getFloatingRateOptionChange(), this::setFloatingRateOptionChange);
			merger.mergeRosetta(getContract(), o.getContract(), this::getOrCreateContract);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AccrualOptionChangeNotificationSequence0 _that = getType().cast(o);
		
			if (!Objects.equals(fixedRateOptionChange, _that.getFixedRateOptionChange())) return false;
			if (!Objects.equals(floatingRateOptionChange, _that.getFloatingRateOptionChange())) return false;
			if (!ListEquals.listEquals(contract, _that.getContract())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fixedRateOptionChange != null ? fixedRateOptionChange.hashCode() : 0);
			_result = 31 * _result + (floatingRateOptionChange != null ? floatingRateOptionChange.hashCode() : 0);
			_result = 31 * _result + (contract != null ? contract.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccrualOptionChangeNotificationSequence0Builder {" +
				"fixedRateOptionChange=" + this.fixedRateOptionChange + ", " +
				"floatingRateOptionChange=" + this.floatingRateOptionChange + ", " +
				"contract=" + this.contract +
			'}';
		}
	}
}
