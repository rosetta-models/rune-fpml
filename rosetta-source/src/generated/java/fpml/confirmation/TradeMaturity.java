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
import com.rosetta.model.lib.records.Date;
import com.rosetta.util.ListEquals;
import fpml.confirmation.PartyTradeIdentifier;
import fpml.confirmation.TradeMaturity;
import fpml.confirmation.TradeMaturity.TradeMaturityBuilder;
import fpml.confirmation.TradeMaturity.TradeMaturityBuilderImpl;
import fpml.confirmation.TradeMaturity.TradeMaturityImpl;
import fpml.confirmation.meta.TradeMaturityMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A structure describing a trade maturing.
 * @version ${project.version}
 */
@RosettaDataType(value="TradeMaturity", builder=TradeMaturity.TradeMaturityBuilderImpl.class, version="${project.version}")
public interface TradeMaturity extends RosettaModelObject {

	TradeMaturityMeta metaData = new TradeMaturityMeta();

	/*********************** Getter Methods  ***********************/
	List<? extends PartyTradeIdentifier> getTradeIdentifier();
	Date getDate();

	/*********************** Build Methods  ***********************/
	TradeMaturity build();
	
	TradeMaturity.TradeMaturityBuilder toBuilder();
	
	static TradeMaturity.TradeMaturityBuilder builder() {
		return new TradeMaturity.TradeMaturityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeMaturity> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TradeMaturity> getType() {
		return TradeMaturity.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("tradeIdentifier"), processor, PartyTradeIdentifier.class, getTradeIdentifier());
		processor.processBasic(path.newSubPath("date"), Date.class, getDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeMaturityBuilder extends TradeMaturity, RosettaModelObjectBuilder {
		PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreateTradeIdentifier(int _index);
		List<? extends PartyTradeIdentifier.PartyTradeIdentifierBuilder> getTradeIdentifier();
		TradeMaturity.TradeMaturityBuilder addTradeIdentifier(PartyTradeIdentifier tradeIdentifier0);
		TradeMaturity.TradeMaturityBuilder addTradeIdentifier(PartyTradeIdentifier tradeIdentifier1, int _idx);
		TradeMaturity.TradeMaturityBuilder addTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifier2);
		TradeMaturity.TradeMaturityBuilder setTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifier3);
		TradeMaturity.TradeMaturityBuilder setDate(Date date);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("tradeIdentifier"), processor, PartyTradeIdentifier.PartyTradeIdentifierBuilder.class, getTradeIdentifier());
			processor.processBasic(path.newSubPath("date"), Date.class, getDate(), this);
		}
		

		TradeMaturity.TradeMaturityBuilder prune();
	}

	/*********************** Immutable Implementation of TradeMaturity  ***********************/
	class TradeMaturityImpl implements TradeMaturity {
		private final List<? extends PartyTradeIdentifier> tradeIdentifier;
		private final Date date;
		
		protected TradeMaturityImpl(TradeMaturity.TradeMaturityBuilder builder) {
			this.tradeIdentifier = ofNullable(builder.getTradeIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.date = builder.getDate();
		}
		
		@Override
		@RosettaAttribute("tradeIdentifier")
		public List<? extends PartyTradeIdentifier> getTradeIdentifier() {
			return tradeIdentifier;
		}
		
		@Override
		@RosettaAttribute("date")
		public Date getDate() {
			return date;
		}
		
		@Override
		public TradeMaturity build() {
			return this;
		}
		
		@Override
		public TradeMaturity.TradeMaturityBuilder toBuilder() {
			TradeMaturity.TradeMaturityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeMaturity.TradeMaturityBuilder builder) {
			ofNullable(getTradeIdentifier()).ifPresent(builder::setTradeIdentifier);
			ofNullable(getDate()).ifPresent(builder::setDate);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeMaturity _that = getType().cast(o);
		
			if (!ListEquals.listEquals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			if (!Objects.equals(date, _that.getDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeMaturity {" +
				"tradeIdentifier=" + this.tradeIdentifier + ", " +
				"date=" + this.date +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeMaturity  ***********************/
	class TradeMaturityBuilderImpl implements TradeMaturity.TradeMaturityBuilder {
	
		protected List<PartyTradeIdentifier.PartyTradeIdentifierBuilder> tradeIdentifier = new ArrayList<>();
		protected Date date;
	
		public TradeMaturityBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("tradeIdentifier")
		public List<? extends PartyTradeIdentifier.PartyTradeIdentifierBuilder> getTradeIdentifier() {
			return tradeIdentifier;
		}
		
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreateTradeIdentifier(int _index) {
		
			if (tradeIdentifier==null) {
				this.tradeIdentifier = new ArrayList<>();
			}
			PartyTradeIdentifier.PartyTradeIdentifierBuilder result;
			return getIndex(tradeIdentifier, _index, () -> {
						PartyTradeIdentifier.PartyTradeIdentifierBuilder newTradeIdentifier = PartyTradeIdentifier.builder();
						return newTradeIdentifier;
					});
		}
		
		@Override
		@RosettaAttribute("date")
		public Date getDate() {
			return date;
		}
		
		@Override
		public TradeMaturity.TradeMaturityBuilder addTradeIdentifier(PartyTradeIdentifier tradeIdentifier) {
			if (tradeIdentifier!=null) this.tradeIdentifier.add(tradeIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public TradeMaturity.TradeMaturityBuilder addTradeIdentifier(PartyTradeIdentifier tradeIdentifier, int _idx) {
			getIndex(this.tradeIdentifier, _idx, () -> tradeIdentifier.toBuilder());
			return this;
		}
		@Override 
		public TradeMaturity.TradeMaturityBuilder addTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifiers) {
			if (tradeIdentifiers != null) {
				for (PartyTradeIdentifier toAdd : tradeIdentifiers) {
					this.tradeIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("tradeIdentifier")
		public TradeMaturity.TradeMaturityBuilder setTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifiers) {
			if (tradeIdentifiers == null)  {
				this.tradeIdentifier = new ArrayList<>();
			}
			else {
				this.tradeIdentifier = tradeIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("date")
		public TradeMaturity.TradeMaturityBuilder setDate(Date date) {
			this.date = date==null?null:date;
			return this;
		}
		
		@Override
		public TradeMaturity build() {
			return new TradeMaturity.TradeMaturityImpl(this);
		}
		
		@Override
		public TradeMaturity.TradeMaturityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeMaturity.TradeMaturityBuilder prune() {
			tradeIdentifier = tradeIdentifier.stream().filter(b->b!=null).<PartyTradeIdentifier.PartyTradeIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTradeIdentifier()!=null && getTradeIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeMaturity.TradeMaturityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeMaturity.TradeMaturityBuilder o = (TradeMaturity.TradeMaturityBuilder) other;
			
			merger.mergeRosetta(getTradeIdentifier(), o.getTradeIdentifier(), this::getOrCreateTradeIdentifier);
			
			merger.mergeBasic(getDate(), o.getDate(), this::setDate);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeMaturity _that = getType().cast(o);
		
			if (!ListEquals.listEquals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			if (!Objects.equals(date, _that.getDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeMaturityBuilder {" +
				"tradeIdentifier=" + this.tradeIdentifier + ", " +
				"date=" + this.date +
			'}';
		}
	}
}
