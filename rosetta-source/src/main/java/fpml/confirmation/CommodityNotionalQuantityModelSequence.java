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
import fpml.confirmation.CommodityNotionalQuantity;
import fpml.confirmation.CommodityNotionalQuantityModelSequence;
import fpml.confirmation.CommodityNotionalQuantityModelSequence.CommodityNotionalQuantityModelSequenceBuilder;
import fpml.confirmation.CommodityNotionalQuantityModelSequence.CommodityNotionalQuantityModelSequenceBuilderImpl;
import fpml.confirmation.CommodityNotionalQuantityModelSequence.CommodityNotionalQuantityModelSequenceImpl;
import fpml.confirmation.CommodityNotionalQuantitySchedule;
import fpml.confirmation.CommoditySettlementPeriodsNotionalQuantity;
import fpml.confirmation.meta.CommodityNotionalQuantityModelSequenceMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CommodityNotionalQuantityModelSequence", builder=CommodityNotionalQuantityModelSequence.CommodityNotionalQuantityModelSequenceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CommodityNotionalQuantityModelSequence extends RosettaModelObject {

	CommodityNotionalQuantityModelSequenceMeta metaData = new CommodityNotionalQuantityModelSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Allows the documentation of a shaped notional trade where the notional changes over the life of the transaction.
	 */
	CommodityNotionalQuantitySchedule getNotionalQuantitySchedule();
	/**
	 * The Notional Quantity.
	 */
	CommodityNotionalQuantity getNotionalQuantity();
	/**
	 * For an electricity transaction, the Notional Quantity for a one or more groups of Settlement Periods to which the Notional Quantity is based. If the schedule differs for different groups of Settlement Periods, this element should be repeated.
	 */
	List<? extends CommoditySettlementPeriodsNotionalQuantity> getSettlementPeriodsNotionalQuantity();
	/**
	 * The Total Notional Quantity.
	 */
	BigDecimal getTotalNotionalQuantity();

	/*********************** Build Methods  ***********************/
	CommodityNotionalQuantityModelSequence build();
	
	CommodityNotionalQuantityModelSequence.CommodityNotionalQuantityModelSequenceBuilder toBuilder();
	
	static CommodityNotionalQuantityModelSequence.CommodityNotionalQuantityModelSequenceBuilder builder() {
		return new CommodityNotionalQuantityModelSequence.CommodityNotionalQuantityModelSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityNotionalQuantityModelSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityNotionalQuantityModelSequence> getType() {
		return CommodityNotionalQuantityModelSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("notionalQuantitySchedule"), processor, CommodityNotionalQuantitySchedule.class, getNotionalQuantitySchedule());
		processRosetta(path.newSubPath("notionalQuantity"), processor, CommodityNotionalQuantity.class, getNotionalQuantity());
		processRosetta(path.newSubPath("settlementPeriodsNotionalQuantity"), processor, CommoditySettlementPeriodsNotionalQuantity.class, getSettlementPeriodsNotionalQuantity());
		processor.processBasic(path.newSubPath("totalNotionalQuantity"), BigDecimal.class, getTotalNotionalQuantity(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityNotionalQuantityModelSequenceBuilder extends CommodityNotionalQuantityModelSequence, RosettaModelObjectBuilder {
		CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder getOrCreateNotionalQuantitySchedule();
		CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder getNotionalQuantitySchedule();
		CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getOrCreateNotionalQuantity();
		CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getNotionalQuantity();
		CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilder getOrCreateSettlementPeriodsNotionalQuantity(int _index);
		List<? extends CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilder> getSettlementPeriodsNotionalQuantity();
		CommodityNotionalQuantityModelSequence.CommodityNotionalQuantityModelSequenceBuilder setNotionalQuantitySchedule(CommodityNotionalQuantitySchedule notionalQuantitySchedule);
		CommodityNotionalQuantityModelSequence.CommodityNotionalQuantityModelSequenceBuilder setNotionalQuantity(CommodityNotionalQuantity notionalQuantity);
		CommodityNotionalQuantityModelSequence.CommodityNotionalQuantityModelSequenceBuilder addSettlementPeriodsNotionalQuantity(CommoditySettlementPeriodsNotionalQuantity settlementPeriodsNotionalQuantity0);
		CommodityNotionalQuantityModelSequence.CommodityNotionalQuantityModelSequenceBuilder addSettlementPeriodsNotionalQuantity(CommoditySettlementPeriodsNotionalQuantity settlementPeriodsNotionalQuantity1, int _idx);
		CommodityNotionalQuantityModelSequence.CommodityNotionalQuantityModelSequenceBuilder addSettlementPeriodsNotionalQuantity(List<? extends CommoditySettlementPeriodsNotionalQuantity> settlementPeriodsNotionalQuantity2);
		CommodityNotionalQuantityModelSequence.CommodityNotionalQuantityModelSequenceBuilder setSettlementPeriodsNotionalQuantity(List<? extends CommoditySettlementPeriodsNotionalQuantity> settlementPeriodsNotionalQuantity3);
		CommodityNotionalQuantityModelSequence.CommodityNotionalQuantityModelSequenceBuilder setTotalNotionalQuantity(BigDecimal totalNotionalQuantity);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("notionalQuantitySchedule"), processor, CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder.class, getNotionalQuantitySchedule());
			processRosetta(path.newSubPath("notionalQuantity"), processor, CommodityNotionalQuantity.CommodityNotionalQuantityBuilder.class, getNotionalQuantity());
			processRosetta(path.newSubPath("settlementPeriodsNotionalQuantity"), processor, CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilder.class, getSettlementPeriodsNotionalQuantity());
			processor.processBasic(path.newSubPath("totalNotionalQuantity"), BigDecimal.class, getTotalNotionalQuantity(), this);
		}
		

		CommodityNotionalQuantityModelSequence.CommodityNotionalQuantityModelSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityNotionalQuantityModelSequence  ***********************/
	class CommodityNotionalQuantityModelSequenceImpl implements CommodityNotionalQuantityModelSequence {
		private final CommodityNotionalQuantitySchedule notionalQuantitySchedule;
		private final CommodityNotionalQuantity notionalQuantity;
		private final List<? extends CommoditySettlementPeriodsNotionalQuantity> settlementPeriodsNotionalQuantity;
		private final BigDecimal totalNotionalQuantity;
		
		protected CommodityNotionalQuantityModelSequenceImpl(CommodityNotionalQuantityModelSequence.CommodityNotionalQuantityModelSequenceBuilder builder) {
			this.notionalQuantitySchedule = ofNullable(builder.getNotionalQuantitySchedule()).map(f->f.build()).orElse(null);
			this.notionalQuantity = ofNullable(builder.getNotionalQuantity()).map(f->f.build()).orElse(null);
			this.settlementPeriodsNotionalQuantity = ofNullable(builder.getSettlementPeriodsNotionalQuantity()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.totalNotionalQuantity = builder.getTotalNotionalQuantity();
		}
		
		@Override
		@RosettaAttribute("notionalQuantitySchedule")
		public CommodityNotionalQuantitySchedule getNotionalQuantitySchedule() {
			return notionalQuantitySchedule;
		}
		
		@Override
		@RosettaAttribute("notionalQuantity")
		public CommodityNotionalQuantity getNotionalQuantity() {
			return notionalQuantity;
		}
		
		@Override
		@RosettaAttribute("settlementPeriodsNotionalQuantity")
		public List<? extends CommoditySettlementPeriodsNotionalQuantity> getSettlementPeriodsNotionalQuantity() {
			return settlementPeriodsNotionalQuantity;
		}
		
		@Override
		@RosettaAttribute("totalNotionalQuantity")
		public BigDecimal getTotalNotionalQuantity() {
			return totalNotionalQuantity;
		}
		
		@Override
		public CommodityNotionalQuantityModelSequence build() {
			return this;
		}
		
		@Override
		public CommodityNotionalQuantityModelSequence.CommodityNotionalQuantityModelSequenceBuilder toBuilder() {
			CommodityNotionalQuantityModelSequence.CommodityNotionalQuantityModelSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityNotionalQuantityModelSequence.CommodityNotionalQuantityModelSequenceBuilder builder) {
			ofNullable(getNotionalQuantitySchedule()).ifPresent(builder::setNotionalQuantitySchedule);
			ofNullable(getNotionalQuantity()).ifPresent(builder::setNotionalQuantity);
			ofNullable(getSettlementPeriodsNotionalQuantity()).ifPresent(builder::setSettlementPeriodsNotionalQuantity);
			ofNullable(getTotalNotionalQuantity()).ifPresent(builder::setTotalNotionalQuantity);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityNotionalQuantityModelSequence _that = getType().cast(o);
		
			if (!Objects.equals(notionalQuantitySchedule, _that.getNotionalQuantitySchedule())) return false;
			if (!Objects.equals(notionalQuantity, _that.getNotionalQuantity())) return false;
			if (!ListEquals.listEquals(settlementPeriodsNotionalQuantity, _that.getSettlementPeriodsNotionalQuantity())) return false;
			if (!Objects.equals(totalNotionalQuantity, _that.getTotalNotionalQuantity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (notionalQuantitySchedule != null ? notionalQuantitySchedule.hashCode() : 0);
			_result = 31 * _result + (notionalQuantity != null ? notionalQuantity.hashCode() : 0);
			_result = 31 * _result + (settlementPeriodsNotionalQuantity != null ? settlementPeriodsNotionalQuantity.hashCode() : 0);
			_result = 31 * _result + (totalNotionalQuantity != null ? totalNotionalQuantity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityNotionalQuantityModelSequence {" +
				"notionalQuantitySchedule=" + this.notionalQuantitySchedule + ", " +
				"notionalQuantity=" + this.notionalQuantity + ", " +
				"settlementPeriodsNotionalQuantity=" + this.settlementPeriodsNotionalQuantity + ", " +
				"totalNotionalQuantity=" + this.totalNotionalQuantity +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityNotionalQuantityModelSequence  ***********************/
	class CommodityNotionalQuantityModelSequenceBuilderImpl implements CommodityNotionalQuantityModelSequence.CommodityNotionalQuantityModelSequenceBuilder {
	
		protected CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder notionalQuantitySchedule;
		protected CommodityNotionalQuantity.CommodityNotionalQuantityBuilder notionalQuantity;
		protected List<CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilder> settlementPeriodsNotionalQuantity = new ArrayList<>();
		protected BigDecimal totalNotionalQuantity;
	
		public CommodityNotionalQuantityModelSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("notionalQuantitySchedule")
		public CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder getNotionalQuantitySchedule() {
			return notionalQuantitySchedule;
		}
		
		@Override
		public CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder getOrCreateNotionalQuantitySchedule() {
			CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder result;
			if (notionalQuantitySchedule!=null) {
				result = notionalQuantitySchedule;
			}
			else {
				result = notionalQuantitySchedule = CommodityNotionalQuantitySchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("notionalQuantity")
		public CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getNotionalQuantity() {
			return notionalQuantity;
		}
		
		@Override
		public CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getOrCreateNotionalQuantity() {
			CommodityNotionalQuantity.CommodityNotionalQuantityBuilder result;
			if (notionalQuantity!=null) {
				result = notionalQuantity;
			}
			else {
				result = notionalQuantity = CommodityNotionalQuantity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementPeriodsNotionalQuantity")
		public List<? extends CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilder> getSettlementPeriodsNotionalQuantity() {
			return settlementPeriodsNotionalQuantity;
		}
		
		@Override
		public CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilder getOrCreateSettlementPeriodsNotionalQuantity(int _index) {
		
			if (settlementPeriodsNotionalQuantity==null) {
				this.settlementPeriodsNotionalQuantity = new ArrayList<>();
			}
			CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilder result;
			return getIndex(settlementPeriodsNotionalQuantity, _index, () -> {
						CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilder newSettlementPeriodsNotionalQuantity = CommoditySettlementPeriodsNotionalQuantity.builder();
						return newSettlementPeriodsNotionalQuantity;
					});
		}
		
		@Override
		@RosettaAttribute("totalNotionalQuantity")
		public BigDecimal getTotalNotionalQuantity() {
			return totalNotionalQuantity;
		}
		
		@Override
		@RosettaAttribute("notionalQuantitySchedule")
		public CommodityNotionalQuantityModelSequence.CommodityNotionalQuantityModelSequenceBuilder setNotionalQuantitySchedule(CommodityNotionalQuantitySchedule notionalQuantitySchedule) {
			this.notionalQuantitySchedule = notionalQuantitySchedule==null?null:notionalQuantitySchedule.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("notionalQuantity")
		public CommodityNotionalQuantityModelSequence.CommodityNotionalQuantityModelSequenceBuilder setNotionalQuantity(CommodityNotionalQuantity notionalQuantity) {
			this.notionalQuantity = notionalQuantity==null?null:notionalQuantity.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("settlementPeriodsNotionalQuantity")
		public CommodityNotionalQuantityModelSequence.CommodityNotionalQuantityModelSequenceBuilder addSettlementPeriodsNotionalQuantity(CommoditySettlementPeriodsNotionalQuantity settlementPeriodsNotionalQuantity) {
			if (settlementPeriodsNotionalQuantity!=null) this.settlementPeriodsNotionalQuantity.add(settlementPeriodsNotionalQuantity.toBuilder());
			return this;
		}
		
		@Override
		public CommodityNotionalQuantityModelSequence.CommodityNotionalQuantityModelSequenceBuilder addSettlementPeriodsNotionalQuantity(CommoditySettlementPeriodsNotionalQuantity settlementPeriodsNotionalQuantity, int _idx) {
			getIndex(this.settlementPeriodsNotionalQuantity, _idx, () -> settlementPeriodsNotionalQuantity.toBuilder());
			return this;
		}
		@Override 
		public CommodityNotionalQuantityModelSequence.CommodityNotionalQuantityModelSequenceBuilder addSettlementPeriodsNotionalQuantity(List<? extends CommoditySettlementPeriodsNotionalQuantity> settlementPeriodsNotionalQuantitys) {
			if (settlementPeriodsNotionalQuantitys != null) {
				for (CommoditySettlementPeriodsNotionalQuantity toAdd : settlementPeriodsNotionalQuantitys) {
					this.settlementPeriodsNotionalQuantity.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public CommodityNotionalQuantityModelSequence.CommodityNotionalQuantityModelSequenceBuilder setSettlementPeriodsNotionalQuantity(List<? extends CommoditySettlementPeriodsNotionalQuantity> settlementPeriodsNotionalQuantitys) {
			if (settlementPeriodsNotionalQuantitys == null)  {
				this.settlementPeriodsNotionalQuantity = new ArrayList<>();
			}
			else {
				this.settlementPeriodsNotionalQuantity = settlementPeriodsNotionalQuantitys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("totalNotionalQuantity")
		public CommodityNotionalQuantityModelSequence.CommodityNotionalQuantityModelSequenceBuilder setTotalNotionalQuantity(BigDecimal totalNotionalQuantity) {
			this.totalNotionalQuantity = totalNotionalQuantity==null?null:totalNotionalQuantity;
			return this;
		}
		
		@Override
		public CommodityNotionalQuantityModelSequence build() {
			return new CommodityNotionalQuantityModelSequence.CommodityNotionalQuantityModelSequenceImpl(this);
		}
		
		@Override
		public CommodityNotionalQuantityModelSequence.CommodityNotionalQuantityModelSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityNotionalQuantityModelSequence.CommodityNotionalQuantityModelSequenceBuilder prune() {
			if (notionalQuantitySchedule!=null && !notionalQuantitySchedule.prune().hasData()) notionalQuantitySchedule = null;
			if (notionalQuantity!=null && !notionalQuantity.prune().hasData()) notionalQuantity = null;
			settlementPeriodsNotionalQuantity = settlementPeriodsNotionalQuantity.stream().filter(b->b!=null).<CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNotionalQuantitySchedule()!=null && getNotionalQuantitySchedule().hasData()) return true;
			if (getNotionalQuantity()!=null && getNotionalQuantity().hasData()) return true;
			if (getSettlementPeriodsNotionalQuantity()!=null && getSettlementPeriodsNotionalQuantity().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTotalNotionalQuantity()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityNotionalQuantityModelSequence.CommodityNotionalQuantityModelSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityNotionalQuantityModelSequence.CommodityNotionalQuantityModelSequenceBuilder o = (CommodityNotionalQuantityModelSequence.CommodityNotionalQuantityModelSequenceBuilder) other;
			
			merger.mergeRosetta(getNotionalQuantitySchedule(), o.getNotionalQuantitySchedule(), this::setNotionalQuantitySchedule);
			merger.mergeRosetta(getNotionalQuantity(), o.getNotionalQuantity(), this::setNotionalQuantity);
			merger.mergeRosetta(getSettlementPeriodsNotionalQuantity(), o.getSettlementPeriodsNotionalQuantity(), this::getOrCreateSettlementPeriodsNotionalQuantity);
			
			merger.mergeBasic(getTotalNotionalQuantity(), o.getTotalNotionalQuantity(), this::setTotalNotionalQuantity);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityNotionalQuantityModelSequence _that = getType().cast(o);
		
			if (!Objects.equals(notionalQuantitySchedule, _that.getNotionalQuantitySchedule())) return false;
			if (!Objects.equals(notionalQuantity, _that.getNotionalQuantity())) return false;
			if (!ListEquals.listEquals(settlementPeriodsNotionalQuantity, _that.getSettlementPeriodsNotionalQuantity())) return false;
			if (!Objects.equals(totalNotionalQuantity, _that.getTotalNotionalQuantity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (notionalQuantitySchedule != null ? notionalQuantitySchedule.hashCode() : 0);
			_result = 31 * _result + (notionalQuantity != null ? notionalQuantity.hashCode() : 0);
			_result = 31 * _result + (settlementPeriodsNotionalQuantity != null ? settlementPeriodsNotionalQuantity.hashCode() : 0);
			_result = 31 * _result + (totalNotionalQuantity != null ? totalNotionalQuantity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityNotionalQuantityModelSequenceBuilder {" +
				"notionalQuantitySchedule=" + this.notionalQuantitySchedule + ", " +
				"notionalQuantity=" + this.notionalQuantity + ", " +
				"settlementPeriodsNotionalQuantity=" + this.settlementPeriodsNotionalQuantity + ", " +
				"totalNotionalQuantity=" + this.totalNotionalQuantity +
			'}';
		}
	}
}
