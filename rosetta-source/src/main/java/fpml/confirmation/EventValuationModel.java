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
import fpml.confirmation.BasicQuotation;
import fpml.confirmation.EventValuationModel;
import fpml.confirmation.EventValuationModel.EventValuationModelBuilder;
import fpml.confirmation.EventValuationModel.EventValuationModelBuilderImpl;
import fpml.confirmation.EventValuationModel.EventValuationModelImpl;
import fpml.confirmation.meta.EventValuationModelMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A model group holding valuation information for an event.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="EventValuationModel", builder=EventValuationModel.EventValuationModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface EventValuationModel extends RosettaModelObject {

	EventValuationModelMeta metaData = new EventValuationModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Pricing information for the trade.
	 */
	List<? extends BasicQuotation> getQuote();

	/*********************** Build Methods  ***********************/
	EventValuationModel build();
	
	EventValuationModel.EventValuationModelBuilder toBuilder();
	
	static EventValuationModel.EventValuationModelBuilder builder() {
		return new EventValuationModel.EventValuationModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EventValuationModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends EventValuationModel> getType() {
		return EventValuationModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("quote"), processor, BasicQuotation.class, getQuote());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EventValuationModelBuilder extends EventValuationModel, RosettaModelObjectBuilder {
		BasicQuotation.BasicQuotationBuilder getOrCreateQuote(int _index);
		List<? extends BasicQuotation.BasicQuotationBuilder> getQuote();
		EventValuationModel.EventValuationModelBuilder addQuote(BasicQuotation quote0);
		EventValuationModel.EventValuationModelBuilder addQuote(BasicQuotation quote1, int _idx);
		EventValuationModel.EventValuationModelBuilder addQuote(List<? extends BasicQuotation> quote2);
		EventValuationModel.EventValuationModelBuilder setQuote(List<? extends BasicQuotation> quote3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("quote"), processor, BasicQuotation.BasicQuotationBuilder.class, getQuote());
		}
		

		EventValuationModel.EventValuationModelBuilder prune();
	}

	/*********************** Immutable Implementation of EventValuationModel  ***********************/
	class EventValuationModelImpl implements EventValuationModel {
		private final List<? extends BasicQuotation> quote;
		
		protected EventValuationModelImpl(EventValuationModel.EventValuationModelBuilder builder) {
			this.quote = ofNullable(builder.getQuote()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("quote")
		public List<? extends BasicQuotation> getQuote() {
			return quote;
		}
		
		@Override
		public EventValuationModel build() {
			return this;
		}
		
		@Override
		public EventValuationModel.EventValuationModelBuilder toBuilder() {
			EventValuationModel.EventValuationModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EventValuationModel.EventValuationModelBuilder builder) {
			ofNullable(getQuote()).ifPresent(builder::setQuote);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EventValuationModel _that = getType().cast(o);
		
			if (!ListEquals.listEquals(quote, _that.getQuote())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (quote != null ? quote.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EventValuationModel {" +
				"quote=" + this.quote +
			'}';
		}
	}

	/*********************** Builder Implementation of EventValuationModel  ***********************/
	class EventValuationModelBuilderImpl implements EventValuationModel.EventValuationModelBuilder {
	
		protected List<BasicQuotation.BasicQuotationBuilder> quote = new ArrayList<>();
	
		public EventValuationModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("quote")
		public List<? extends BasicQuotation.BasicQuotationBuilder> getQuote() {
			return quote;
		}
		
		@Override
		public BasicQuotation.BasicQuotationBuilder getOrCreateQuote(int _index) {
		
			if (quote==null) {
				this.quote = new ArrayList<>();
			}
			BasicQuotation.BasicQuotationBuilder result;
			return getIndex(quote, _index, () -> {
						BasicQuotation.BasicQuotationBuilder newQuote = BasicQuotation.builder();
						return newQuote;
					});
		}
		
		@Override
		@RosettaAttribute("quote")
		public EventValuationModel.EventValuationModelBuilder addQuote(BasicQuotation quote) {
			if (quote!=null) this.quote.add(quote.toBuilder());
			return this;
		}
		
		@Override
		public EventValuationModel.EventValuationModelBuilder addQuote(BasicQuotation quote, int _idx) {
			getIndex(this.quote, _idx, () -> quote.toBuilder());
			return this;
		}
		@Override 
		public EventValuationModel.EventValuationModelBuilder addQuote(List<? extends BasicQuotation> quotes) {
			if (quotes != null) {
				for (BasicQuotation toAdd : quotes) {
					this.quote.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public EventValuationModel.EventValuationModelBuilder setQuote(List<? extends BasicQuotation> quotes) {
			if (quotes == null)  {
				this.quote = new ArrayList<>();
			}
			else {
				this.quote = quotes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public EventValuationModel build() {
			return new EventValuationModel.EventValuationModelImpl(this);
		}
		
		@Override
		public EventValuationModel.EventValuationModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EventValuationModel.EventValuationModelBuilder prune() {
			quote = quote.stream().filter(b->b!=null).<BasicQuotation.BasicQuotationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getQuote()!=null && getQuote().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EventValuationModel.EventValuationModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EventValuationModel.EventValuationModelBuilder o = (EventValuationModel.EventValuationModelBuilder) other;
			
			merger.mergeRosetta(getQuote(), o.getQuote(), this::getOrCreateQuote);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EventValuationModel _that = getType().cast(o);
		
			if (!ListEquals.listEquals(quote, _that.getQuote())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (quote != null ? quote.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EventValuationModelBuilder {" +
				"quote=" + this.quote +
			'}';
		}
	}
}
