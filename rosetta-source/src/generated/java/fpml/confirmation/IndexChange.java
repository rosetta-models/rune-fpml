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
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.ChangeEvent;
import fpml.confirmation.ChangeEvent.ChangeEventBuilder;
import fpml.confirmation.ChangeEvent.ChangeEventBuilderImpl;
import fpml.confirmation.ChangeEvent.ChangeEventImpl;
import fpml.confirmation.IndexChange;
import fpml.confirmation.IndexChange.IndexChangeBuilder;
import fpml.confirmation.IndexChange.IndexChangeBuilderImpl;
import fpml.confirmation.IndexChange.IndexChangeImpl;
import fpml.confirmation.Money;
import fpml.confirmation.meta.IndexChangeMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Describes a change due to an index component being adjusted. A structure describing the effect of a change to an index.
 * @version ${project.version}
 */
@RosettaDataType(value="IndexChange", builder=IndexChange.IndexChangeBuilderImpl.class, version="${project.version}")
public interface IndexChange extends ChangeEvent {

	IndexChangeMeta metaData = new IndexChangeMeta();

	/*********************** Getter Methods  ***********************/
	BigDecimal getIndexFactor();
	Money getFactoredCalculationAmount();

	/*********************** Build Methods  ***********************/
	IndexChange build();
	
	IndexChange.IndexChangeBuilder toBuilder();
	
	static IndexChange.IndexChangeBuilder builder() {
		return new IndexChange.IndexChangeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends IndexChange> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends IndexChange> getType() {
		return IndexChange.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
		processor.processBasic(path.newSubPath("indexFactor"), BigDecimal.class, getIndexFactor(), this);
		processRosetta(path.newSubPath("factoredCalculationAmount"), processor, Money.class, getFactoredCalculationAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface IndexChangeBuilder extends IndexChange, ChangeEvent.ChangeEventBuilder {
		Money.MoneyBuilder getOrCreateFactoredCalculationAmount();
		Money.MoneyBuilder getFactoredCalculationAmount();
		IndexChange.IndexChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		IndexChange.IndexChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		IndexChange.IndexChangeBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		IndexChange.IndexChangeBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		IndexChange.IndexChangeBuilder setIndexFactor(BigDecimal indexFactor);
		IndexChange.IndexChangeBuilder setFactoredCalculationAmount(Money factoredCalculationAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processor.processBasic(path.newSubPath("indexFactor"), BigDecimal.class, getIndexFactor(), this);
			processRosetta(path.newSubPath("factoredCalculationAmount"), processor, Money.MoneyBuilder.class, getFactoredCalculationAmount());
		}
		

		IndexChange.IndexChangeBuilder prune();
	}

	/*********************** Immutable Implementation of IndexChange  ***********************/
	class IndexChangeImpl extends ChangeEvent.ChangeEventImpl implements IndexChange {
		private final BigDecimal indexFactor;
		private final Money factoredCalculationAmount;
		
		protected IndexChangeImpl(IndexChange.IndexChangeBuilder builder) {
			super(builder);
			this.indexFactor = builder.getIndexFactor();
			this.factoredCalculationAmount = ofNullable(builder.getFactoredCalculationAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("indexFactor")
		public BigDecimal getIndexFactor() {
			return indexFactor;
		}
		
		@Override
		@RosettaAttribute("factoredCalculationAmount")
		public Money getFactoredCalculationAmount() {
			return factoredCalculationAmount;
		}
		
		@Override
		public IndexChange build() {
			return this;
		}
		
		@Override
		public IndexChange.IndexChangeBuilder toBuilder() {
			IndexChange.IndexChangeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(IndexChange.IndexChangeBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getIndexFactor()).ifPresent(builder::setIndexFactor);
			ofNullable(getFactoredCalculationAmount()).ifPresent(builder::setFactoredCalculationAmount);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			IndexChange _that = getType().cast(o);
		
			if (!Objects.equals(indexFactor, _that.getIndexFactor())) return false;
			if (!Objects.equals(factoredCalculationAmount, _that.getFactoredCalculationAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (indexFactor != null ? indexFactor.hashCode() : 0);
			_result = 31 * _result + (factoredCalculationAmount != null ? factoredCalculationAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IndexChange {" +
				"indexFactor=" + this.indexFactor + ", " +
				"factoredCalculationAmount=" + this.factoredCalculationAmount +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of IndexChange  ***********************/
	class IndexChangeBuilderImpl extends ChangeEvent.ChangeEventBuilderImpl  implements IndexChange.IndexChangeBuilder {
	
		protected BigDecimal indexFactor;
		protected Money.MoneyBuilder factoredCalculationAmount;
	
		public IndexChangeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("indexFactor")
		public BigDecimal getIndexFactor() {
			return indexFactor;
		}
		
		@Override
		@RosettaAttribute("factoredCalculationAmount")
		public Money.MoneyBuilder getFactoredCalculationAmount() {
			return factoredCalculationAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateFactoredCalculationAmount() {
			Money.MoneyBuilder result;
			if (factoredCalculationAmount!=null) {
				result = factoredCalculationAmount;
			}
			else {
				result = factoredCalculationAmount = Money.builder();
			}
			
			return result;
		}
		
		@Override
		public IndexChange.IndexChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public IndexChange.IndexChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public IndexChange.IndexChangeBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("eventIdentifier")
		public IndexChange.IndexChangeBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers == null)  {
				this.eventIdentifier = new ArrayList<>();
			}
			else {
				this.eventIdentifier = eventIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("indexFactor")
		public IndexChange.IndexChangeBuilder setIndexFactor(BigDecimal indexFactor) {
			this.indexFactor = indexFactor==null?null:indexFactor;
			return this;
		}
		@Override
		@RosettaAttribute("factoredCalculationAmount")
		public IndexChange.IndexChangeBuilder setFactoredCalculationAmount(Money factoredCalculationAmount) {
			this.factoredCalculationAmount = factoredCalculationAmount==null?null:factoredCalculationAmount.toBuilder();
			return this;
		}
		
		@Override
		public IndexChange build() {
			return new IndexChange.IndexChangeImpl(this);
		}
		
		@Override
		public IndexChange.IndexChangeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IndexChange.IndexChangeBuilder prune() {
			super.prune();
			if (factoredCalculationAmount!=null && !factoredCalculationAmount.prune().hasData()) factoredCalculationAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getIndexFactor()!=null) return true;
			if (getFactoredCalculationAmount()!=null && getFactoredCalculationAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IndexChange.IndexChangeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			IndexChange.IndexChangeBuilder o = (IndexChange.IndexChangeBuilder) other;
			
			merger.mergeRosetta(getFactoredCalculationAmount(), o.getFactoredCalculationAmount(), this::setFactoredCalculationAmount);
			
			merger.mergeBasic(getIndexFactor(), o.getIndexFactor(), this::setIndexFactor);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			IndexChange _that = getType().cast(o);
		
			if (!Objects.equals(indexFactor, _that.getIndexFactor())) return false;
			if (!Objects.equals(factoredCalculationAmount, _that.getFactoredCalculationAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (indexFactor != null ? indexFactor.hashCode() : 0);
			_result = 31 * _result + (factoredCalculationAmount != null ? factoredCalculationAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IndexChangeBuilder {" +
				"indexFactor=" + this.indexFactor + ", " +
				"factoredCalculationAmount=" + this.factoredCalculationAmount +
			'}' + " " + super.toString();
		}
	}
}
