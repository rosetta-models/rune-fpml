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
import fpml.confirmation.LoanAllocationIdentifier;
import fpml.confirmation.LoanTradeAllocationDetailsModel;
import fpml.confirmation.LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilder;
import fpml.confirmation.LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilderImpl;
import fpml.confirmation.LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelImpl;
import fpml.confirmation.LoanTradeSummary;
import fpml.confirmation.meta.LoanTradeAllocationDetailsModelMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A model used to reference a single loan trade together with all associated allocations.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="LoanTradeAllocationDetailsModel", builder=LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface LoanTradeAllocationDetailsModel extends RosettaModelObject {

	LoanTradeAllocationDetailsModelMeta metaData = new LoanTradeAllocationDetailsModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A party-specific allocation identifier.
	 */
	List<? extends LoanAllocationIdentifier> getAllocationId();
	LoanTradeSummary getTradeSummary();

	/*********************** Build Methods  ***********************/
	LoanTradeAllocationDetailsModel build();
	
	LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilder toBuilder();
	
	static LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilder builder() {
		return new LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanTradeAllocationDetailsModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanTradeAllocationDetailsModel> getType() {
		return LoanTradeAllocationDetailsModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("allocationId"), processor, LoanAllocationIdentifier.class, getAllocationId());
		processRosetta(path.newSubPath("tradeSummary"), processor, LoanTradeSummary.class, getTradeSummary());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanTradeAllocationDetailsModelBuilder extends LoanTradeAllocationDetailsModel, RosettaModelObjectBuilder {
		LoanAllocationIdentifier.LoanAllocationIdentifierBuilder getOrCreateAllocationId(int _index);
		List<? extends LoanAllocationIdentifier.LoanAllocationIdentifierBuilder> getAllocationId();
		LoanTradeSummary.LoanTradeSummaryBuilder getOrCreateTradeSummary();
		LoanTradeSummary.LoanTradeSummaryBuilder getTradeSummary();
		LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilder addAllocationId(LoanAllocationIdentifier allocationId0);
		LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilder addAllocationId(LoanAllocationIdentifier allocationId1, int _idx);
		LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilder addAllocationId(List<? extends LoanAllocationIdentifier> allocationId2);
		LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilder setAllocationId(List<? extends LoanAllocationIdentifier> allocationId3);
		LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilder setTradeSummary(LoanTradeSummary tradeSummary);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("allocationId"), processor, LoanAllocationIdentifier.LoanAllocationIdentifierBuilder.class, getAllocationId());
			processRosetta(path.newSubPath("tradeSummary"), processor, LoanTradeSummary.LoanTradeSummaryBuilder.class, getTradeSummary());
		}
		

		LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilder prune();
	}

	/*********************** Immutable Implementation of LoanTradeAllocationDetailsModel  ***********************/
	class LoanTradeAllocationDetailsModelImpl implements LoanTradeAllocationDetailsModel {
		private final List<? extends LoanAllocationIdentifier> allocationId;
		private final LoanTradeSummary tradeSummary;
		
		protected LoanTradeAllocationDetailsModelImpl(LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilder builder) {
			this.allocationId = ofNullable(builder.getAllocationId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.tradeSummary = ofNullable(builder.getTradeSummary()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("allocationId")
		public List<? extends LoanAllocationIdentifier> getAllocationId() {
			return allocationId;
		}
		
		@Override
		@RosettaAttribute("tradeSummary")
		public LoanTradeSummary getTradeSummary() {
			return tradeSummary;
		}
		
		@Override
		public LoanTradeAllocationDetailsModel build() {
			return this;
		}
		
		@Override
		public LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilder toBuilder() {
			LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilder builder) {
			ofNullable(getAllocationId()).ifPresent(builder::setAllocationId);
			ofNullable(getTradeSummary()).ifPresent(builder::setTradeSummary);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanTradeAllocationDetailsModel _that = getType().cast(o);
		
			if (!ListEquals.listEquals(allocationId, _that.getAllocationId())) return false;
			if (!Objects.equals(tradeSummary, _that.getTradeSummary())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (allocationId != null ? allocationId.hashCode() : 0);
			_result = 31 * _result + (tradeSummary != null ? tradeSummary.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradeAllocationDetailsModel {" +
				"allocationId=" + this.allocationId + ", " +
				"tradeSummary=" + this.tradeSummary +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanTradeAllocationDetailsModel  ***********************/
	class LoanTradeAllocationDetailsModelBuilderImpl implements LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilder {
	
		protected List<LoanAllocationIdentifier.LoanAllocationIdentifierBuilder> allocationId = new ArrayList<>();
		protected LoanTradeSummary.LoanTradeSummaryBuilder tradeSummary;
	
		public LoanTradeAllocationDetailsModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("allocationId")
		public List<? extends LoanAllocationIdentifier.LoanAllocationIdentifierBuilder> getAllocationId() {
			return allocationId;
		}
		
		@Override
		public LoanAllocationIdentifier.LoanAllocationIdentifierBuilder getOrCreateAllocationId(int _index) {
		
			if (allocationId==null) {
				this.allocationId = new ArrayList<>();
			}
			LoanAllocationIdentifier.LoanAllocationIdentifierBuilder result;
			return getIndex(allocationId, _index, () -> {
						LoanAllocationIdentifier.LoanAllocationIdentifierBuilder newAllocationId = LoanAllocationIdentifier.builder();
						return newAllocationId;
					});
		}
		
		@Override
		@RosettaAttribute("tradeSummary")
		public LoanTradeSummary.LoanTradeSummaryBuilder getTradeSummary() {
			return tradeSummary;
		}
		
		@Override
		public LoanTradeSummary.LoanTradeSummaryBuilder getOrCreateTradeSummary() {
			LoanTradeSummary.LoanTradeSummaryBuilder result;
			if (tradeSummary!=null) {
				result = tradeSummary;
			}
			else {
				result = tradeSummary = LoanTradeSummary.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("allocationId")
		public LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilder addAllocationId(LoanAllocationIdentifier allocationId) {
			if (allocationId!=null) this.allocationId.add(allocationId.toBuilder());
			return this;
		}
		
		@Override
		public LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilder addAllocationId(LoanAllocationIdentifier allocationId, int _idx) {
			getIndex(this.allocationId, _idx, () -> allocationId.toBuilder());
			return this;
		}
		@Override 
		public LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilder addAllocationId(List<? extends LoanAllocationIdentifier> allocationIds) {
			if (allocationIds != null) {
				for (LoanAllocationIdentifier toAdd : allocationIds) {
					this.allocationId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilder setAllocationId(List<? extends LoanAllocationIdentifier> allocationIds) {
			if (allocationIds == null)  {
				this.allocationId = new ArrayList<>();
			}
			else {
				this.allocationId = allocationIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("tradeSummary")
		public LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilder setTradeSummary(LoanTradeSummary tradeSummary) {
			this.tradeSummary = tradeSummary==null?null:tradeSummary.toBuilder();
			return this;
		}
		
		@Override
		public LoanTradeAllocationDetailsModel build() {
			return new LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelImpl(this);
		}
		
		@Override
		public LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilder prune() {
			allocationId = allocationId.stream().filter(b->b!=null).<LoanAllocationIdentifier.LoanAllocationIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (tradeSummary!=null && !tradeSummary.prune().hasData()) tradeSummary = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAllocationId()!=null && getAllocationId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTradeSummary()!=null && getTradeSummary().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilder o = (LoanTradeAllocationDetailsModel.LoanTradeAllocationDetailsModelBuilder) other;
			
			merger.mergeRosetta(getAllocationId(), o.getAllocationId(), this::getOrCreateAllocationId);
			merger.mergeRosetta(getTradeSummary(), o.getTradeSummary(), this::setTradeSummary);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanTradeAllocationDetailsModel _that = getType().cast(o);
		
			if (!ListEquals.listEquals(allocationId, _that.getAllocationId())) return false;
			if (!Objects.equals(tradeSummary, _that.getTradeSummary())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (allocationId != null ? allocationId.hashCode() : 0);
			_result = 31 * _result + (tradeSummary != null ? tradeSummary.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradeAllocationDetailsModelBuilder {" +
				"allocationId=" + this.allocationId + ", " +
				"tradeSummary=" + this.tradeSummary +
			'}';
		}
	}
}
