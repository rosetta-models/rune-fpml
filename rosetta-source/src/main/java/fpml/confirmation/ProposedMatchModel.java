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
import fpml.confirmation.MatchId;
import fpml.confirmation.ProposedMatchModel;
import fpml.confirmation.ProposedMatchModel.ProposedMatchModelBuilder;
import fpml.confirmation.ProposedMatchModel.ProposedMatchModelBuilderImpl;
import fpml.confirmation.ProposedMatchModel.ProposedMatchModelImpl;
import fpml.confirmation.TradeDifference;
import fpml.confirmation.meta.ProposedMatchModelMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A structure that describes a potential match for a trade or event, together with descriptors of that match (quality, etc.).
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="ProposedMatchModel", builder=ProposedMatchModel.ProposedMatchModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface ProposedMatchModel extends RosettaModelObject {

	ProposedMatchModelMeta metaData = new ProposedMatchModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A unique identifier assigned by the matching service to each set of matched positions.
	 */
	MatchId getMatchId();
	/**
	 * A type used to record the details of a difference between two sides of a business event.
	 */
	List<? extends TradeDifference> getDifference();
	/**
	 * Numeric score to represent the quality of the match.
	 */
	BigDecimal getMatchScore();

	/*********************** Build Methods  ***********************/
	ProposedMatchModel build();
	
	ProposedMatchModel.ProposedMatchModelBuilder toBuilder();
	
	static ProposedMatchModel.ProposedMatchModelBuilder builder() {
		return new ProposedMatchModel.ProposedMatchModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ProposedMatchModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ProposedMatchModel> getType() {
		return ProposedMatchModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("matchId"), processor, MatchId.class, getMatchId());
		processRosetta(path.newSubPath("difference"), processor, TradeDifference.class, getDifference());
		processor.processBasic(path.newSubPath("matchScore"), BigDecimal.class, getMatchScore(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ProposedMatchModelBuilder extends ProposedMatchModel, RosettaModelObjectBuilder {
		MatchId.MatchIdBuilder getOrCreateMatchId();
		MatchId.MatchIdBuilder getMatchId();
		TradeDifference.TradeDifferenceBuilder getOrCreateDifference(int _index);
		List<? extends TradeDifference.TradeDifferenceBuilder> getDifference();
		ProposedMatchModel.ProposedMatchModelBuilder setMatchId(MatchId matchId);
		ProposedMatchModel.ProposedMatchModelBuilder addDifference(TradeDifference difference0);
		ProposedMatchModel.ProposedMatchModelBuilder addDifference(TradeDifference difference1, int _idx);
		ProposedMatchModel.ProposedMatchModelBuilder addDifference(List<? extends TradeDifference> difference2);
		ProposedMatchModel.ProposedMatchModelBuilder setDifference(List<? extends TradeDifference> difference3);
		ProposedMatchModel.ProposedMatchModelBuilder setMatchScore(BigDecimal matchScore);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("matchId"), processor, MatchId.MatchIdBuilder.class, getMatchId());
			processRosetta(path.newSubPath("difference"), processor, TradeDifference.TradeDifferenceBuilder.class, getDifference());
			processor.processBasic(path.newSubPath("matchScore"), BigDecimal.class, getMatchScore(), this);
		}
		

		ProposedMatchModel.ProposedMatchModelBuilder prune();
	}

	/*********************** Immutable Implementation of ProposedMatchModel  ***********************/
	class ProposedMatchModelImpl implements ProposedMatchModel {
		private final MatchId matchId;
		private final List<? extends TradeDifference> difference;
		private final BigDecimal matchScore;
		
		protected ProposedMatchModelImpl(ProposedMatchModel.ProposedMatchModelBuilder builder) {
			this.matchId = ofNullable(builder.getMatchId()).map(f->f.build()).orElse(null);
			this.difference = ofNullable(builder.getDifference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.matchScore = builder.getMatchScore();
		}
		
		@Override
		@RosettaAttribute("matchId")
		public MatchId getMatchId() {
			return matchId;
		}
		
		@Override
		@RosettaAttribute("difference")
		public List<? extends TradeDifference> getDifference() {
			return difference;
		}
		
		@Override
		@RosettaAttribute("matchScore")
		public BigDecimal getMatchScore() {
			return matchScore;
		}
		
		@Override
		public ProposedMatchModel build() {
			return this;
		}
		
		@Override
		public ProposedMatchModel.ProposedMatchModelBuilder toBuilder() {
			ProposedMatchModel.ProposedMatchModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ProposedMatchModel.ProposedMatchModelBuilder builder) {
			ofNullable(getMatchId()).ifPresent(builder::setMatchId);
			ofNullable(getDifference()).ifPresent(builder::setDifference);
			ofNullable(getMatchScore()).ifPresent(builder::setMatchScore);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ProposedMatchModel _that = getType().cast(o);
		
			if (!Objects.equals(matchId, _that.getMatchId())) return false;
			if (!ListEquals.listEquals(difference, _that.getDifference())) return false;
			if (!Objects.equals(matchScore, _that.getMatchScore())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (matchId != null ? matchId.hashCode() : 0);
			_result = 31 * _result + (difference != null ? difference.hashCode() : 0);
			_result = 31 * _result + (matchScore != null ? matchScore.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ProposedMatchModel {" +
				"matchId=" + this.matchId + ", " +
				"difference=" + this.difference + ", " +
				"matchScore=" + this.matchScore +
			'}';
		}
	}

	/*********************** Builder Implementation of ProposedMatchModel  ***********************/
	class ProposedMatchModelBuilderImpl implements ProposedMatchModel.ProposedMatchModelBuilder {
	
		protected MatchId.MatchIdBuilder matchId;
		protected List<TradeDifference.TradeDifferenceBuilder> difference = new ArrayList<>();
		protected BigDecimal matchScore;
	
		public ProposedMatchModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("matchId")
		public MatchId.MatchIdBuilder getMatchId() {
			return matchId;
		}
		
		@Override
		public MatchId.MatchIdBuilder getOrCreateMatchId() {
			MatchId.MatchIdBuilder result;
			if (matchId!=null) {
				result = matchId;
			}
			else {
				result = matchId = MatchId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("difference")
		public List<? extends TradeDifference.TradeDifferenceBuilder> getDifference() {
			return difference;
		}
		
		@Override
		public TradeDifference.TradeDifferenceBuilder getOrCreateDifference(int _index) {
		
			if (difference==null) {
				this.difference = new ArrayList<>();
			}
			TradeDifference.TradeDifferenceBuilder result;
			return getIndex(difference, _index, () -> {
						TradeDifference.TradeDifferenceBuilder newDifference = TradeDifference.builder();
						return newDifference;
					});
		}
		
		@Override
		@RosettaAttribute("matchScore")
		public BigDecimal getMatchScore() {
			return matchScore;
		}
		
		@Override
		@RosettaAttribute("matchId")
		public ProposedMatchModel.ProposedMatchModelBuilder setMatchId(MatchId matchId) {
			this.matchId = matchId==null?null:matchId.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("difference")
		public ProposedMatchModel.ProposedMatchModelBuilder addDifference(TradeDifference difference) {
			if (difference!=null) this.difference.add(difference.toBuilder());
			return this;
		}
		
		@Override
		public ProposedMatchModel.ProposedMatchModelBuilder addDifference(TradeDifference difference, int _idx) {
			getIndex(this.difference, _idx, () -> difference.toBuilder());
			return this;
		}
		@Override 
		public ProposedMatchModel.ProposedMatchModelBuilder addDifference(List<? extends TradeDifference> differences) {
			if (differences != null) {
				for (TradeDifference toAdd : differences) {
					this.difference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ProposedMatchModel.ProposedMatchModelBuilder setDifference(List<? extends TradeDifference> differences) {
			if (differences == null)  {
				this.difference = new ArrayList<>();
			}
			else {
				this.difference = differences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("matchScore")
		public ProposedMatchModel.ProposedMatchModelBuilder setMatchScore(BigDecimal matchScore) {
			this.matchScore = matchScore==null?null:matchScore;
			return this;
		}
		
		@Override
		public ProposedMatchModel build() {
			return new ProposedMatchModel.ProposedMatchModelImpl(this);
		}
		
		@Override
		public ProposedMatchModel.ProposedMatchModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ProposedMatchModel.ProposedMatchModelBuilder prune() {
			if (matchId!=null && !matchId.prune().hasData()) matchId = null;
			difference = difference.stream().filter(b->b!=null).<TradeDifference.TradeDifferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMatchId()!=null && getMatchId().hasData()) return true;
			if (getDifference()!=null && getDifference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getMatchScore()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ProposedMatchModel.ProposedMatchModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ProposedMatchModel.ProposedMatchModelBuilder o = (ProposedMatchModel.ProposedMatchModelBuilder) other;
			
			merger.mergeRosetta(getMatchId(), o.getMatchId(), this::setMatchId);
			merger.mergeRosetta(getDifference(), o.getDifference(), this::getOrCreateDifference);
			
			merger.mergeBasic(getMatchScore(), o.getMatchScore(), this::setMatchScore);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ProposedMatchModel _that = getType().cast(o);
		
			if (!Objects.equals(matchId, _that.getMatchId())) return false;
			if (!ListEquals.listEquals(difference, _that.getDifference())) return false;
			if (!Objects.equals(matchScore, _that.getMatchScore())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (matchId != null ? matchId.hashCode() : 0);
			_result = 31 * _result + (difference != null ? difference.hashCode() : 0);
			_result = 31 * _result + (matchScore != null ? matchScore.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ProposedMatchModelBuilder {" +
				"matchId=" + this.matchId + ", " +
				"difference=" + this.difference + ", " +
				"matchScore=" + this.matchScore +
			'}';
		}
	}
}
