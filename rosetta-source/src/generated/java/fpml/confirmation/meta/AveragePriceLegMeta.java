package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AveragePriceLeg;
import fpml.confirmation.validation.AveragePriceLegTypeFormatValidator;
import fpml.confirmation.validation.AveragePriceLegValidator;
import fpml.confirmation.validation.exists.AveragePriceLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AveragePriceLeg.class)
public class AveragePriceLegMeta implements RosettaMetaData<AveragePriceLeg> {

	@Override
	public List<Validator<? super AveragePriceLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AveragePriceLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AveragePriceLeg> validator() {
		return new AveragePriceLegValidator();
	}

	@Override
	public Validator<? super AveragePriceLeg> typeFormatValidator() {
		return new AveragePriceLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AveragePriceLeg, Set<String>> onlyExistsValidator() {
		return new AveragePriceLegOnlyExistsValidator();
	}
}
