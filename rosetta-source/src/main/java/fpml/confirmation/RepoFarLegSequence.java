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
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.CollateralValuation;
import fpml.confirmation.DeliveryMethod;
import fpml.confirmation.RepoFarLegSequence;
import fpml.confirmation.RepoFarLegSequence.RepoFarLegSequenceBuilder;
import fpml.confirmation.RepoFarLegSequence.RepoFarLegSequenceBuilderImpl;
import fpml.confirmation.RepoFarLegSequence.RepoFarLegSequenceImpl;
import fpml.confirmation.meta.RepoFarLegSequenceMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="RepoFarLegSequence", builder=RepoFarLegSequence.RepoFarLegSequenceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface RepoFarLegSequence extends RosettaModelObject {

	RepoFarLegSequenceMeta metaData = new RepoFarLegSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies a delivery method for the security transaction.
	 */
	DeliveryMethod getDeliveryMethod();
	/**
	 * Delivery Date for the transaction. Delivery Date can be populated when it is not equal to the Settlement Date.
	 */
	AdjustableOrRelativeDate getDeliveryDate();
	/**
	 * Collateral element is used to carry the quantity and price details that are required to ensure that a repo contract is executed at fair value, with the value of the collateral matching the cash amount of the repo. Collateral is declared as optional here, with multiple cardinalities, since there can be a repo &quot;Multi&quot;, with multiple instruments specified, or a &quot;Cash Borrow/Loan&quot; and “TriPartyRepo” with no collateral. In general cases, however it should be specified. This element can be omitted in farLeg.
	 */
	List<? extends CollateralValuation> getCollateral();

	/*********************** Build Methods  ***********************/
	RepoFarLegSequence build();
	
	RepoFarLegSequence.RepoFarLegSequenceBuilder toBuilder();
	
	static RepoFarLegSequence.RepoFarLegSequenceBuilder builder() {
		return new RepoFarLegSequence.RepoFarLegSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RepoFarLegSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends RepoFarLegSequence> getType() {
		return RepoFarLegSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("deliveryMethod"), processor, DeliveryMethod.class, getDeliveryMethod());
		processRosetta(path.newSubPath("deliveryDate"), processor, AdjustableOrRelativeDate.class, getDeliveryDate());
		processRosetta(path.newSubPath("collateral"), processor, CollateralValuation.class, getCollateral());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RepoFarLegSequenceBuilder extends RepoFarLegSequence, RosettaModelObjectBuilder {
		DeliveryMethod.DeliveryMethodBuilder getOrCreateDeliveryMethod();
		DeliveryMethod.DeliveryMethodBuilder getDeliveryMethod();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateDeliveryDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getDeliveryDate();
		CollateralValuation.CollateralValuationBuilder getOrCreateCollateral(int _index);
		List<? extends CollateralValuation.CollateralValuationBuilder> getCollateral();
		RepoFarLegSequence.RepoFarLegSequenceBuilder setDeliveryMethod(DeliveryMethod deliveryMethod);
		RepoFarLegSequence.RepoFarLegSequenceBuilder setDeliveryDate(AdjustableOrRelativeDate deliveryDate);
		RepoFarLegSequence.RepoFarLegSequenceBuilder addCollateral(CollateralValuation collateral0);
		RepoFarLegSequence.RepoFarLegSequenceBuilder addCollateral(CollateralValuation collateral1, int _idx);
		RepoFarLegSequence.RepoFarLegSequenceBuilder addCollateral(List<? extends CollateralValuation> collateral2);
		RepoFarLegSequence.RepoFarLegSequenceBuilder setCollateral(List<? extends CollateralValuation> collateral3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("deliveryMethod"), processor, DeliveryMethod.DeliveryMethodBuilder.class, getDeliveryMethod());
			processRosetta(path.newSubPath("deliveryDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getDeliveryDate());
			processRosetta(path.newSubPath("collateral"), processor, CollateralValuation.CollateralValuationBuilder.class, getCollateral());
		}
		

		RepoFarLegSequence.RepoFarLegSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of RepoFarLegSequence  ***********************/
	class RepoFarLegSequenceImpl implements RepoFarLegSequence {
		private final DeliveryMethod deliveryMethod;
		private final AdjustableOrRelativeDate deliveryDate;
		private final List<? extends CollateralValuation> collateral;
		
		protected RepoFarLegSequenceImpl(RepoFarLegSequence.RepoFarLegSequenceBuilder builder) {
			this.deliveryMethod = ofNullable(builder.getDeliveryMethod()).map(f->f.build()).orElse(null);
			this.deliveryDate = ofNullable(builder.getDeliveryDate()).map(f->f.build()).orElse(null);
			this.collateral = ofNullable(builder.getCollateral()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("deliveryMethod")
		public DeliveryMethod getDeliveryMethod() {
			return deliveryMethod;
		}
		
		@Override
		@RosettaAttribute("deliveryDate")
		public AdjustableOrRelativeDate getDeliveryDate() {
			return deliveryDate;
		}
		
		@Override
		@RosettaAttribute("collateral")
		public List<? extends CollateralValuation> getCollateral() {
			return collateral;
		}
		
		@Override
		public RepoFarLegSequence build() {
			return this;
		}
		
		@Override
		public RepoFarLegSequence.RepoFarLegSequenceBuilder toBuilder() {
			RepoFarLegSequence.RepoFarLegSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RepoFarLegSequence.RepoFarLegSequenceBuilder builder) {
			ofNullable(getDeliveryMethod()).ifPresent(builder::setDeliveryMethod);
			ofNullable(getDeliveryDate()).ifPresent(builder::setDeliveryDate);
			ofNullable(getCollateral()).ifPresent(builder::setCollateral);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RepoFarLegSequence _that = getType().cast(o);
		
			if (!Objects.equals(deliveryMethod, _that.getDeliveryMethod())) return false;
			if (!Objects.equals(deliveryDate, _that.getDeliveryDate())) return false;
			if (!ListEquals.listEquals(collateral, _that.getCollateral())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (deliveryMethod != null ? deliveryMethod.hashCode() : 0);
			_result = 31 * _result + (deliveryDate != null ? deliveryDate.hashCode() : 0);
			_result = 31 * _result + (collateral != null ? collateral.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RepoFarLegSequence {" +
				"deliveryMethod=" + this.deliveryMethod + ", " +
				"deliveryDate=" + this.deliveryDate + ", " +
				"collateral=" + this.collateral +
			'}';
		}
	}

	/*********************** Builder Implementation of RepoFarLegSequence  ***********************/
	class RepoFarLegSequenceBuilderImpl implements RepoFarLegSequence.RepoFarLegSequenceBuilder {
	
		protected DeliveryMethod.DeliveryMethodBuilder deliveryMethod;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder deliveryDate;
		protected List<CollateralValuation.CollateralValuationBuilder> collateral = new ArrayList<>();
	
		public RepoFarLegSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("deliveryMethod")
		public DeliveryMethod.DeliveryMethodBuilder getDeliveryMethod() {
			return deliveryMethod;
		}
		
		@Override
		public DeliveryMethod.DeliveryMethodBuilder getOrCreateDeliveryMethod() {
			DeliveryMethod.DeliveryMethodBuilder result;
			if (deliveryMethod!=null) {
				result = deliveryMethod;
			}
			else {
				result = deliveryMethod = DeliveryMethod.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("deliveryDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getDeliveryDate() {
			return deliveryDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateDeliveryDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (deliveryDate!=null) {
				result = deliveryDate;
			}
			else {
				result = deliveryDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("collateral")
		public List<? extends CollateralValuation.CollateralValuationBuilder> getCollateral() {
			return collateral;
		}
		
		@Override
		public CollateralValuation.CollateralValuationBuilder getOrCreateCollateral(int _index) {
		
			if (collateral==null) {
				this.collateral = new ArrayList<>();
			}
			CollateralValuation.CollateralValuationBuilder result;
			return getIndex(collateral, _index, () -> {
						CollateralValuation.CollateralValuationBuilder newCollateral = CollateralValuation.builder();
						return newCollateral;
					});
		}
		
		@Override
		@RosettaAttribute("deliveryMethod")
		public RepoFarLegSequence.RepoFarLegSequenceBuilder setDeliveryMethod(DeliveryMethod deliveryMethod) {
			this.deliveryMethod = deliveryMethod==null?null:deliveryMethod.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("deliveryDate")
		public RepoFarLegSequence.RepoFarLegSequenceBuilder setDeliveryDate(AdjustableOrRelativeDate deliveryDate) {
			this.deliveryDate = deliveryDate==null?null:deliveryDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("collateral")
		public RepoFarLegSequence.RepoFarLegSequenceBuilder addCollateral(CollateralValuation collateral) {
			if (collateral!=null) this.collateral.add(collateral.toBuilder());
			return this;
		}
		
		@Override
		public RepoFarLegSequence.RepoFarLegSequenceBuilder addCollateral(CollateralValuation collateral, int _idx) {
			getIndex(this.collateral, _idx, () -> collateral.toBuilder());
			return this;
		}
		@Override 
		public RepoFarLegSequence.RepoFarLegSequenceBuilder addCollateral(List<? extends CollateralValuation> collaterals) {
			if (collaterals != null) {
				for (CollateralValuation toAdd : collaterals) {
					this.collateral.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public RepoFarLegSequence.RepoFarLegSequenceBuilder setCollateral(List<? extends CollateralValuation> collaterals) {
			if (collaterals == null)  {
				this.collateral = new ArrayList<>();
			}
			else {
				this.collateral = collaterals.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public RepoFarLegSequence build() {
			return new RepoFarLegSequence.RepoFarLegSequenceImpl(this);
		}
		
		@Override
		public RepoFarLegSequence.RepoFarLegSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RepoFarLegSequence.RepoFarLegSequenceBuilder prune() {
			if (deliveryMethod!=null && !deliveryMethod.prune().hasData()) deliveryMethod = null;
			if (deliveryDate!=null && !deliveryDate.prune().hasData()) deliveryDate = null;
			collateral = collateral.stream().filter(b->b!=null).<CollateralValuation.CollateralValuationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDeliveryMethod()!=null && getDeliveryMethod().hasData()) return true;
			if (getDeliveryDate()!=null && getDeliveryDate().hasData()) return true;
			if (getCollateral()!=null && getCollateral().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RepoFarLegSequence.RepoFarLegSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RepoFarLegSequence.RepoFarLegSequenceBuilder o = (RepoFarLegSequence.RepoFarLegSequenceBuilder) other;
			
			merger.mergeRosetta(getDeliveryMethod(), o.getDeliveryMethod(), this::setDeliveryMethod);
			merger.mergeRosetta(getDeliveryDate(), o.getDeliveryDate(), this::setDeliveryDate);
			merger.mergeRosetta(getCollateral(), o.getCollateral(), this::getOrCreateCollateral);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RepoFarLegSequence _that = getType().cast(o);
		
			if (!Objects.equals(deliveryMethod, _that.getDeliveryMethod())) return false;
			if (!Objects.equals(deliveryDate, _that.getDeliveryDate())) return false;
			if (!ListEquals.listEquals(collateral, _that.getCollateral())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (deliveryMethod != null ? deliveryMethod.hashCode() : 0);
			_result = 31 * _result + (deliveryDate != null ? deliveryDate.hashCode() : 0);
			_result = 31 * _result + (collateral != null ? collateral.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RepoFarLegSequenceBuilder {" +
				"deliveryMethod=" + this.deliveryMethod + ", " +
				"deliveryDate=" + this.deliveryDate + ", " +
				"collateral=" + this.collateral +
			'}';
		}
	}
}
