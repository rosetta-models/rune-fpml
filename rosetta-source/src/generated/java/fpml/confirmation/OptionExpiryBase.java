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
import fpml.confirmation.OptionExpiryBase;
import fpml.confirmation.OptionExpiryBase.OptionExpiryBaseBuilder;
import fpml.confirmation.OptionExpiryBase.OptionExpiryBaseBuilderImpl;
import fpml.confirmation.OptionExpiryBase.OptionExpiryBaseImpl;
import fpml.confirmation.PartyTradeIdentifier;
import fpml.confirmation.meta.OptionExpiryBaseMeta;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A structure describing an option expiring.
 * @version ${project.version}
 */
@RosettaDataType(value="OptionExpiryBase", builder=OptionExpiryBase.OptionExpiryBaseBuilderImpl.class, version="${project.version}")
public interface OptionExpiryBase extends RosettaModelObject {

	OptionExpiryBaseMeta metaData = new OptionExpiryBaseMeta();

	/*********************** Getter Methods  ***********************/
	List<? extends PartyTradeIdentifier> getTradeIdentifier();
	Date getDate();
	LocalTime getTime();

	/*********************** Build Methods  ***********************/
	OptionExpiryBase build();
	
	OptionExpiryBase.OptionExpiryBaseBuilder toBuilder();
	
	static OptionExpiryBase.OptionExpiryBaseBuilder builder() {
		return new OptionExpiryBase.OptionExpiryBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OptionExpiryBase> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends OptionExpiryBase> getType() {
		return OptionExpiryBase.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("tradeIdentifier"), processor, PartyTradeIdentifier.class, getTradeIdentifier());
		processor.processBasic(path.newSubPath("date"), Date.class, getDate(), this);
		processor.processBasic(path.newSubPath("time"), LocalTime.class, getTime(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface OptionExpiryBaseBuilder extends OptionExpiryBase, RosettaModelObjectBuilder {
		PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreateTradeIdentifier(int _index);
		List<? extends PartyTradeIdentifier.PartyTradeIdentifierBuilder> getTradeIdentifier();
		OptionExpiryBase.OptionExpiryBaseBuilder addTradeIdentifier(PartyTradeIdentifier tradeIdentifier0);
		OptionExpiryBase.OptionExpiryBaseBuilder addTradeIdentifier(PartyTradeIdentifier tradeIdentifier1, int _idx);
		OptionExpiryBase.OptionExpiryBaseBuilder addTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifier2);
		OptionExpiryBase.OptionExpiryBaseBuilder setTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifier3);
		OptionExpiryBase.OptionExpiryBaseBuilder setDate(Date date);
		OptionExpiryBase.OptionExpiryBaseBuilder setTime(LocalTime time);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("tradeIdentifier"), processor, PartyTradeIdentifier.PartyTradeIdentifierBuilder.class, getTradeIdentifier());
			processor.processBasic(path.newSubPath("date"), Date.class, getDate(), this);
			processor.processBasic(path.newSubPath("time"), LocalTime.class, getTime(), this);
		}
		

		OptionExpiryBase.OptionExpiryBaseBuilder prune();
	}

	/*********************** Immutable Implementation of OptionExpiryBase  ***********************/
	class OptionExpiryBaseImpl implements OptionExpiryBase {
		private final List<? extends PartyTradeIdentifier> tradeIdentifier;
		private final Date date;
		private final LocalTime time;
		
		protected OptionExpiryBaseImpl(OptionExpiryBase.OptionExpiryBaseBuilder builder) {
			this.tradeIdentifier = ofNullable(builder.getTradeIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.date = builder.getDate();
			this.time = builder.getTime();
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
		@RosettaAttribute("time")
		public LocalTime getTime() {
			return time;
		}
		
		@Override
		public OptionExpiryBase build() {
			return this;
		}
		
		@Override
		public OptionExpiryBase.OptionExpiryBaseBuilder toBuilder() {
			OptionExpiryBase.OptionExpiryBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OptionExpiryBase.OptionExpiryBaseBuilder builder) {
			ofNullable(getTradeIdentifier()).ifPresent(builder::setTradeIdentifier);
			ofNullable(getDate()).ifPresent(builder::setDate);
			ofNullable(getTime()).ifPresent(builder::setTime);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionExpiryBase _that = getType().cast(o);
		
			if (!ListEquals.listEquals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			if (!Objects.equals(date, _that.getDate())) return false;
			if (!Objects.equals(time, _that.getTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			_result = 31 * _result + (time != null ? time.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionExpiryBase {" +
				"tradeIdentifier=" + this.tradeIdentifier + ", " +
				"date=" + this.date + ", " +
				"time=" + this.time +
			'}';
		}
	}

	/*********************** Builder Implementation of OptionExpiryBase  ***********************/
	class OptionExpiryBaseBuilderImpl implements OptionExpiryBase.OptionExpiryBaseBuilder {
	
		protected List<PartyTradeIdentifier.PartyTradeIdentifierBuilder> tradeIdentifier = new ArrayList<>();
		protected Date date;
		protected LocalTime time;
	
		public OptionExpiryBaseBuilderImpl() {
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
		@RosettaAttribute("time")
		public LocalTime getTime() {
			return time;
		}
		
		@Override
		public OptionExpiryBase.OptionExpiryBaseBuilder addTradeIdentifier(PartyTradeIdentifier tradeIdentifier) {
			if (tradeIdentifier!=null) this.tradeIdentifier.add(tradeIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public OptionExpiryBase.OptionExpiryBaseBuilder addTradeIdentifier(PartyTradeIdentifier tradeIdentifier, int _idx) {
			getIndex(this.tradeIdentifier, _idx, () -> tradeIdentifier.toBuilder());
			return this;
		}
		@Override 
		public OptionExpiryBase.OptionExpiryBaseBuilder addTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifiers) {
			if (tradeIdentifiers != null) {
				for (PartyTradeIdentifier toAdd : tradeIdentifiers) {
					this.tradeIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("tradeIdentifier")
		public OptionExpiryBase.OptionExpiryBaseBuilder setTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifiers) {
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
		public OptionExpiryBase.OptionExpiryBaseBuilder setDate(Date date) {
			this.date = date==null?null:date;
			return this;
		}
		@Override
		@RosettaAttribute("time")
		public OptionExpiryBase.OptionExpiryBaseBuilder setTime(LocalTime time) {
			this.time = time==null?null:time;
			return this;
		}
		
		@Override
		public OptionExpiryBase build() {
			return new OptionExpiryBase.OptionExpiryBaseImpl(this);
		}
		
		@Override
		public OptionExpiryBase.OptionExpiryBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionExpiryBase.OptionExpiryBaseBuilder prune() {
			tradeIdentifier = tradeIdentifier.stream().filter(b->b!=null).<PartyTradeIdentifier.PartyTradeIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTradeIdentifier()!=null && getTradeIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getDate()!=null) return true;
			if (getTime()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionExpiryBase.OptionExpiryBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OptionExpiryBase.OptionExpiryBaseBuilder o = (OptionExpiryBase.OptionExpiryBaseBuilder) other;
			
			merger.mergeRosetta(getTradeIdentifier(), o.getTradeIdentifier(), this::getOrCreateTradeIdentifier);
			
			merger.mergeBasic(getDate(), o.getDate(), this::setDate);
			merger.mergeBasic(getTime(), o.getTime(), this::setTime);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionExpiryBase _that = getType().cast(o);
		
			if (!ListEquals.listEquals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			if (!Objects.equals(date, _that.getDate())) return false;
			if (!Objects.equals(time, _that.getTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			_result = 31 * _result + (time != null ? time.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionExpiryBaseBuilder {" +
				"tradeIdentifier=" + this.tradeIdentifier + ", " +
				"date=" + this.date + ", " +
				"time=" + this.time +
			'}';
		}
	}
}
