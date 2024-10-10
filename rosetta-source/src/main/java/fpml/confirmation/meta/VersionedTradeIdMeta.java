package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.VersionedTradeId;
import fpml.confirmation.validation.VersionedTradeIdTypeFormatValidator;
import fpml.confirmation.validation.VersionedTradeIdValidator;
import fpml.confirmation.validation.exists.VersionedTradeIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=VersionedTradeId.class)
public class VersionedTradeIdMeta implements RosettaMetaData<VersionedTradeId> {

	@Override
	public List<Validator<? super VersionedTradeId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super VersionedTradeId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super VersionedTradeId> validator() {
		return new VersionedTradeIdValidator();
	}

	@Override
	public Validator<? super VersionedTradeId> typeFormatValidator() {
		return new VersionedTradeIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super VersionedTradeId, Set<String>> onlyExistsValidator() {
		return new VersionedTradeIdOnlyExistsValidator();
	}
}
