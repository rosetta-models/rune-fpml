package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Asian;
import fpml.confirmation.validation.AsianTypeFormatValidator;
import fpml.confirmation.validation.AsianValidator;
import fpml.confirmation.validation.exists.AsianOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=Asian.class)
public class AsianMeta implements RosettaMetaData<Asian> {

	@Override
	public List<Validator<? super Asian>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Asian, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Asian> validator() {
		return new AsianValidator();
	}

	@Override
	public Validator<? super Asian> typeFormatValidator() {
		return new AsianTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Asian, Set<String>> onlyExistsValidator() {
		return new AsianOnlyExistsValidator();
	}
}
